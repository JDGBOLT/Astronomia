package astronomia.util;

import astronomia.Astronomia;
import astronomia.api.core.IConfigurable;
import cofh.api.core.IInitializer;
import cofh.item.ItemBase;
import cofh.util.StringHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;

public abstract class ModItemRegistry {

	private final ArrayList<IInitializer> initializers = new ArrayList<IInitializer>();
	private final ArrayList<IConfigurable> configurables = new ArrayList<IConfigurable>();

	protected abstract void preInitialize();

	protected abstract void initialize();

	protected abstract void postInitialize();

	public void preInit() {

		preInitialize();
		for (IInitializer object : initializers) {
			object.preInit();
		}
	}

	public void init() {

		initialize();
		configure();
		for (IInitializer object : initializers) {
			object.initialize();
		}
	}

	public void postInit() {

		postInitialize();
		for (IInitializer object : initializers) {
			object.postInit();
		}
		initializers.clear();
	}

	public void configure() {

		for (IConfigurable object : configurables) {
			object.configure();
		}
	}

	protected Item addItem(Item item, String name) {

		if (item instanceof ItemBase || ConfigHelper.itemEnabled(name)) {
			item.setUnlocalizedName(name);
			if (GameRegistry.findItem(Astronomia.mod.info.modId, name) == null) {
				GameRegistry.registerItem(item, name);
			}
			if (item instanceof IInitializer) {
				initializers.add((IInitializer) item);
			}
			if (item instanceof IConfigurable) {
				String itemName = item.getUnlocalizedName() + ".name";
				Astronomia.mod.config.getCategory("item." + name).setLanguageKey(itemName).setComment(StringHelper.localize(itemName));
				configurables.add((IConfigurable) item);
			}
		}
		return item;
	}

	protected Block addBlock(Block block, String name) {

		block.setBlockName(name);
		if (GameRegistry.findBlock(Astronomia.mod.info.modId, name) == null) {
			GameRegistry.registerBlock(block, name);
		}
		if (block instanceof IInitializer) {
			initializers.add((IInitializer) block);
		}
		if (block instanceof IConfigurable) {
			String blockName = block.getUnlocalizedName() + ".name";
			Astronomia.mod.config.getCategory("block." + name).setLanguageKey(blockName).setComment(StringHelper.localize(blockName));
			configurables.add((IConfigurable) block);
		}

		return block;
	}

	protected Block addBlock(Block block, Class<? extends ItemBlock> itemBlock, String name) {

		block.setBlockName(name);
		if (GameRegistry.findBlock(Astronomia.mod.info.modId, name) == null) {
			GameRegistry.registerBlock(block, itemBlock, name);
		}
		if (block instanceof IInitializer) {
			initializers.add((IInitializer) block);
		}
		if (block instanceof IConfigurable) {
			String blockName = block.getUnlocalizedName() + ".name";
			Astronomia.mod.config.getCategory("block." + name).setLanguageKey(blockName).setComment(StringHelper.localize(blockName));
			configurables.add((IConfigurable) block);
		}

		return block;
	}

	protected ItemStack addCustomItem(ItemStack item, String name) {

		if (GameRegistry.findItemStack(Astronomia.mod.info.modId, name, 1) == null) {
			GameRegistry.registerCustomItemStack(name, item);
		}
		if (item.getItem() instanceof IInitializer) {
			initializers.add((IInitializer) item.getItem());
		}
		if (item.getItem() instanceof IConfigurable) {
			String itemName = item.getUnlocalizedName() + ".name";
			Astronomia.mod.config.getCategory("item." + name).setLanguageKey(itemName).setComment(StringHelper.localize(itemName));
			configurables.add((IConfigurable) item.getItem());
		}

		return item;
	}
}
