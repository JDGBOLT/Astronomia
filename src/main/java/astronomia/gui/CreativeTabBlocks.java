package astronomia.gui;

import astronomia.Astronomia;
import astronomia.item.AstroItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabBlocks extends CreativeTabs {

	public CreativeTabBlocks() {

		super(Astronomia.mod.info.modId + "Blocks");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack() {
		return AstroItems.basicSpyglass;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {

		return getIconItemStack().getItem();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTabLabel() {

		return Astronomia.mod.info.modId.toLowerCase() + ".creativeTabBlocks";
	}
}
