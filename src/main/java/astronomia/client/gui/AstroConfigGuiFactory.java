package astronomia.client.gui;

import astronomia.Astronomia;
import cpw.mods.fml.client.IModGuiFactory;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AstroConfigGuiFactory implements IModGuiFactory
{
    @Override
    public void initialize(Minecraft minecraftInstance) {}

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() { return AstroConfigGui.class; }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() { return null; }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) { return null; }

    public static class AstroConfigGui extends GuiConfig
    {
        public AstroConfigGui(GuiScreen parentScreen)
        {
            super(parentScreen, getCategories(), Astronomia.mod.info.modId, false, false, Astronomia.mod.info.name,
                    GuiConfig.getAbridgedConfigPath(Astronomia.mod.config.config.toString()));
        }
        private static List<IConfigElement> getCategories()
        {
            List<IConfigElement> categories = new ArrayList<IConfigElement>();
            for (String category : Astronomia.mod.config.config.getCategoryNames())
            {
                categories.add(new ConfigElement(Astronomia.mod.config.config.getCategory(category)));
            }
            return categories;
        }
    }
}
