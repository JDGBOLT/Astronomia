package astronomia.util;

import astronomia.Astronomia;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ConfigHelper {

	public static boolean recipeEnabled(ItemStack out) {

		String type = (out.getItem() instanceof ItemBlock) ? "block": "item";
		String name = out.getUnlocalizedName().split("\\.", 3)[2];
		if ((type.equals("block") && blockEnabled(name)) || (type.equals("item") && itemEnabled(name))) {
			return Astronomia.mod.config.getProperty(type + ".crafting", type + "." + name, true)
					       .setLanguageKey(out.getUnlocalizedName() + ".name").setRequiresMcRestart(true).getBoolean();
		}
		return false;
	}

	public static boolean blockEnabled(String name) {

		String blockName = "block." + Astronomia.mod.info.modId.toLowerCase() + "." + name + ".name";
		return Astronomia.mod.config.getProperty("block.enable", "block." + name, true).setRequiresMcRestart(true).setLanguageKey(blockName).getBoolean();
	}

	public static boolean itemEnabled(String name) {

		String itemName = "item." + Astronomia.mod.info.modId.toLowerCase() + "." + name + ".name";
		return Astronomia.mod.config.getProperty("item.enable", "item." + name, true).setRequiresMcRestart(true).setLanguageKey(itemName).getBoolean();
	}

}
