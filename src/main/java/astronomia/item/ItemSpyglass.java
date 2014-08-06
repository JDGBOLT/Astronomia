package astronomia.item;

import astronomia.api.core.IConfigurable;
import cofh.api.core.IInitializer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;

public class ItemSpyglass extends AstroItemBase implements IInitializer, IConfigurable {

	public ItemSpyglass() {

		super();
		setMaxStackSize(1);
	}

	/* IConfigurable */
	@Override
	public boolean configure() {

		return false;
	}

	/* IInitializer */
	@Override
	public boolean preInit() {

		return false;
	}

	@Override
	public boolean initialize() {

		return false;
	}

	@Override
	public boolean postInit() {

		return false;
	}
}
