package astronomia;

import astronomia.core.AstroMod;
import astronomia.core.AstroProps;
import astronomia.core.CommonProxy;
import astronomia.core.AstroConfig;
import cofh.mod.BaseMod;
import cofh.updater.UpdateManager;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = AstroProps.MODID, version = AstroProps.VERSION, name = AstroProps.NAME,
		    useMetadata = true, guiFactory = AstroProps.GUIFACTORY_CLASS)
public class Astronomia extends BaseMod {

	// Instance of the Mod
	@Mod.Instance(AstroProps.MODID)
	public static Astronomia instance;

	// Proxy to separate server/client side code execution
	@SidedProxy(clientSide = AstroProps.CLIENT_PROXY_CLASS, serverSide = AstroProps.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	// AstroMod variable that contains things such as logging, source jar, and Mod information
	public static AstroMod mod;

	// AstroConfig variable which handles all configuration related tasks
	public static AstroConfig config;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		setConfigFolderBase(event.getModConfigurationDirectory());
		mod = new AstroMod(event.getSourceFile(), _configFolder, event.getModMetadata(),
				                  event.getModLog(), getCommonConfig());
		if (mod.config.get("version", "VersionCheck", true, "Whether to check for mod updates at startup")) {
			UpdateManager.registerUpdater(new UpdateManager(this, mod.info.updateUrl));
		}
		config = new AstroConfig();
		proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {

		FMLCommonHandler.instance().bus().register(instance);
		proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

		proxy.postInit();
		mod.config.cleanUp(false, true);
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent event) {

		if (event.modID.equals(mod.info.modId)) {
			if (mod.config.getConfiguration().hasChanged()) {
				mod.config.save();
				config = new AstroConfig();
			}
		}
	}

	/* BaseMod */
	@Override
	public String getModId() {

		return (mod != null) ? mod.info.modId : AstroProps.MODID;
	}

	@Override
	public String getModName() {

		return (mod != null) ? mod.info.name : AstroProps.NAME;
	}

	@Override
	public String getModVersion() {

		return (mod != null) ? AstroProps.MCVERSION + 'R' + mod.info.version :
				       AstroProps.MCVERSION + 'R' + AstroProps.VERSION;
	}
}
