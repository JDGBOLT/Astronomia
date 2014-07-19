package astronomia;

import astronomia.config.AstroConfig;
import astronomia.proxy.CommonProxy;
import astronomia.util.AstroMod;
import astronomia.reference.AstroProps;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = AstroProps.MODID, version = AstroProps.VERSION, name = AstroProps.NAME,
     useMetadata = true, guiFactory = AstroProps.GUIFACTORY_CLASS)
public class Astronomia
{
    // Instance of the Mod
    @Mod.Instance(value = AstroProps.MODID)
    public static Astronomia instance;

    // Proxy to separate server/client side code execution
    @SidedProxy(clientSide = AstroProps.CLIENT_PROXY_CLASS, serverSide = AstroProps.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;

    // AstroMod variable that contains things such as logging, source jar, and Mod information
    public static AstroMod mod;

    // AstroConfig variable which handles all configuration related tasks
    public static AstroConfig config;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        mod = new AstroMod(event.getSourceFile(), event.getModConfigurationDirectory(), event.getModMetadata(), event.getModLog());
        config = new AstroConfig();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(instance);
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
        if (mod.config.hasChanged()) mod.config.save();
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent event)
    {
        if (event.modID.equals(mod.info.modId))
        {
            if (mod.config.hasChanged())
            {
                mod.config.save();
                config = new AstroConfig();
            }
        }
    }
}
