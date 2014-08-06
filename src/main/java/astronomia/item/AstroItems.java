package astronomia.item;

import astronomia.util.ModItemRegistry;
import net.minecraft.item.ItemStack;

public class AstroItems extends ModItemRegistry {

	@Override
	protected void preInitialize() {

		itemSpyglass = (ItemSpyglass) addItem(new ItemSpyglass(), "spyglass");
		basicSpyglass = itemSpyglass.addItem(0, "basicSpyglass");

	}

	@Override
	protected void initialize() {

	}

	@Override
	protected void postInitialize() {

	}

	// Base Items
	public static ItemSpyglass itemSpyglass;

	// Itemstacks for the Items
	public static ItemStack basicSpyglass;
}
