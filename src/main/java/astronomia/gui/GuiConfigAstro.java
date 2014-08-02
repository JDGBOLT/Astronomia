package astronomia.gui;

import astronomia.Astronomia;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

public class GuiConfigAstro extends GuiConfig {

	public GuiConfigAstro(GuiScreen parentScreen) {

		super(parentScreen, getCategories(), Astronomia.mod.info.modId, false, false, Astronomia.mod.info.name,
				     GuiConfig.getAbridgedConfigPath(Astronomia.mod.config.getConfiguration().toString()));
	}

	private static List<IConfigElement> getCategories() {

		List<IConfigElement> categories = new ArrayList<IConfigElement>();
		for (String category : Astronomia.mod.config.getCategoryNames()) {
			Astronomia.mod.log.info("Category: " + category);
			if (!category.contains(".")) {
				categories.add(new ConfigElement(Astronomia.mod.config.getCategory(category)));
			}
		}
		return categories;
	}
}
