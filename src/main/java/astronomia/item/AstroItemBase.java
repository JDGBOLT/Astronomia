package astronomia.item;

import astronomia.Astronomia;
import astronomia.util.ConfigHelper;
import cofh.item.ItemBase;
import cofh.util.ItemHelper;
import net.minecraft.item.ItemStack;

public class AstroItemBase extends ItemBase {

	public AstroItemBase() {
		super(Astronomia.mod.info.modId.toLowerCase());
		setCreativeTab(Astronomia.creativeTabItems);
	}

	/* Override of the addItem functions to eanble configuration checks before creating the item. */

	@Override
	public ItemStack addItem(int number, String name, int rarity, boolean register) {

		if (ConfigHelper.itemEnabled(getUnlocalizedName().split("\\.", 3)[2] + "." + name)) {
			return super.addItem(number, name, rarity, register);
		}
		return ItemHelper.stack(this);
	}

	@Override
	public ItemStack addItem(int number, String name, int rarity) {

		return addItem(number, name, rarity, true);
	}

	@Override
	public ItemStack addItem(int number, String name) {

		return addItem(number, name, 0);
	}

	@Override
	public ItemStack addOreDictItem(int number, String name, int rarity) {

		if (ConfigHelper.itemEnabled(getUnlocalizedName().split("\\.", 3)[2] + "." + name)) {
			return super.addOreDictItem(number, name, rarity);
		}
		return ItemHelper.stack(this);
	}

	@Override
	public ItemStack addOreDictItem(int number, String name) {

		return addOreDictItem(number, name, 0);
	}
}
