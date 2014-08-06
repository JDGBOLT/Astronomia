package astronomia.util;

import astronomia.util.ConfigHelper;
import cofh.util.ItemHelper;
import net.minecraft.item.ItemStack;

public final class RecipeHelper {

	// Slight wrapper around the CoFHCore ItemHelper recipe methods to also add them to be toggleable within the config

	// Fences + Two Way Conversion
	public static boolean addFenceRecipe(ItemStack out, ItemStack in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addFenceRecipe(out, in);
	}

	public static boolean addFenceRecipe(ItemStack out, String in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addFenceRecipe(out, in);
	}

	public static boolean addTwoWayConversionRecipe(ItemStack out, ItemStack in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addTwoWayConversionRecipe(out, in);
	}

	// Gears
	public static boolean addGearRecipe(ItemStack out, String in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addGearRecipe(out, in);
	}

	public static boolean addGearRecipe(ItemStack out, ItemStack in, ItemStack cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addGearRecipe(out, in, cen);
	}

	public static boolean addGearRecipe(ItemStack out, ItemStack in, String cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addGearRecipe(out, in, cen);
	}

	public static boolean addGearRecipe(ItemStack out, String in, ItemStack cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addGearRecipe(out, in, cen);
	}

	public static boolean addGearRecipe(ItemStack out, String in, String cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addGearRecipe(out, in, cen);
	}

	// Rotated Gears
	public static boolean addGearRotatedRecipe(ItemStack out, ItemStack in, ItemStack cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addRotatedGearRecipe(out, in, cen);
	}

	public static boolean addGearRotatedRecipe(ItemStack out, ItemStack in, String cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addRotatedGearRecipe(out, in, cen);
	}

	public static boolean addGearRotatedRecipe(ItemStack out, String in, ItemStack cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addRotatedGearRecipe(out, in, cen);
	}

	public static boolean addGearRotatedRecipe(ItemStack out, String in, String cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addRotatedGearRecipe(out, in, cen);
	}

	// Storage
	public static boolean addStorageRecipe(ItemStack out, ItemStack in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addStorageRecipe(out, in);
	}

	public static boolean addStorageRecipe(ItemStack out, String in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addStorageRecipe(out, in);
	}

	public static boolean addSmallStorageRecipe(ItemStack out, ItemStack in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSmallStorageRecipe(out, in);
	}

	public static boolean addSmallStorageRecipe(ItemStack out, String in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSmallStorageRecipe(out, in);
	}

	// Reverse Storage
	public static boolean addReverseStorageRecipe(ItemStack out, ItemStack in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addReverseStorageRecipe(out, in);
	}

	public static boolean addReverseStorageRecipe(ItemStack out, String in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addReverseStorageRecipe(out, in);
	}

	public static boolean addReverseSmallStorageRecipe(ItemStack out, ItemStack in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSmallReverseStorageRecipe(out, in);
	}

	public static boolean addReverseSmallStorageRecipe(ItemStack out, String in) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSmallReverseStorageRecipe(out, in);
	}

	// Surround
	public static boolean addSurroundRecipe(ItemStack out, ItemStack in, ItemStack cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSurroundRecipe(out, in, cen);
	}

	public static boolean addSurroundRecipe(ItemStack out, ItemStack in, String cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSurroundRecipe(out, in, cen);
	}

	public static boolean addSurroundRecipe(ItemStack out, String in, ItemStack cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSurroundRecipe(out, in, cen);
	}

	public static boolean addSurroundRecipe(ItemStack out, String in, String cen) {

		return ConfigHelper.recipeEnabled(out) && ItemHelper.addSurroundRecipe(out, in, cen);
	}

}
