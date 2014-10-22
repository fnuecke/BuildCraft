package buildcraft.transport.stripes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import buildcraft.api.stripes.IStripesItemHandler;
import buildcraft.api.stripes.IStripesPipe;

public class StripesHandlerArrow implements IStripesItemHandler {

	@Override
	public boolean shouldHandle(ItemStack stack) {
		return stack.getItem() == Items.arrow;
	}

	@Override
	public boolean handle(World world, int x, int y, int z,
			ForgeDirection direction, ItemStack stack, EntityPlayer player,
			IStripesPipe pipe) {
		stack.stackSize--;

		EntityArrow entityArrow = new EntityArrow(world, player, 0);
		entityArrow.setPosition(x + 0.5d, y + 0.5d, z + 0.5d);
		entityArrow.setDamage(3);
		entityArrow.setKnockbackStrength(1);
		entityArrow.motionX = direction.offsetX * 1.8d + world.rand.nextGaussian() * 0.007499999832361937D;
		entityArrow.motionY = direction.offsetY * 1.8d + world.rand.nextGaussian() * 0.007499999832361937D;
		entityArrow.motionZ = direction.offsetZ * 1.8d + world.rand.nextGaussian() * 0.007499999832361937D;
		world.spawnEntityInWorld(entityArrow);

		return true;
	}

}