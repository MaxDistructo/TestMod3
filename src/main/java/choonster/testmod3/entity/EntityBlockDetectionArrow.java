package choonster.testmod3.entity;

import choonster.testmod3.init.ModItems;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

/**
 * An arrow entity that tells its shooter which block it hit.
 * <p>
 * Test for this thread:
 * http://www.minecraftforge.net/forum/index.php?topic=42677.0
 *
 * @author Choonster
 */
public class EntityBlockDetectionArrow extends EntityModArrow {
	public EntityBlockDetectionArrow(final World worldIn) {
		super(worldIn);
	}

	public EntityBlockDetectionArrow(final World worldIn, final double x, final double y, final double z) {
		super(worldIn, x, y, z);
	}

	public EntityBlockDetectionArrow(final World worldIn, final EntityLivingBase shooter) {
		super(worldIn, shooter);
	}

	@Override
	protected ItemStack getArrowStack() {
		return new ItemStack(ModItems.BLOCK_DETECTION_ARROW);
	}

	@Override
	protected void onHit(final RayTraceResult raytraceResultIn) {
		super.onHit(raytraceResultIn);

		if (raytraceResultIn.typeOfHit == RayTraceResult.Type.BLOCK && shootingEntity != null) {
			final BlockPos pos = raytraceResultIn.getBlockPos();
			final IBlockState state = world.getBlockState(pos).getActualState(world, pos);
			shootingEntity.sendMessage(new TextComponentTranslation("[%s] Block at %s,%s,%s: %s", world.isRemote ? "CLIENT" : "SERVER", pos.getX(), pos.getY(), pos.getZ(), state));
		}
	}
}
