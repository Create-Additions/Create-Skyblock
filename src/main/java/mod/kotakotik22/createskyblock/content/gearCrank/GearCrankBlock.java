package mod.kotakotik22.createskyblock.content.gearCrank;

import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.components.crank.HandCrankBlock;
import com.simibubi.create.content.contraptions.relays.elementary.ICogWheel;
import mod.kotakotik22.createskyblock.register.ModTiles;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;

public class GearCrankBlock extends HandCrankBlock implements ICogWheel {
    public GearCrankBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean hasShaftTowards(IWorldReader world, BlockPos pos, BlockState state, Direction face) {
        return false;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return ModTiles.GEAR_CRANK.create();
    }

    public Vector3d getCrankRenderTranslate(Direction facing, float o) {
        return new Vector3d(0,0,0).add(facing.getStepX() * o, facing.getStepY() * o, facing.getStepZ() * o);
    }

    public Vector3d getCrankRenderTranslate(Direction facing) {
        return getCrankRenderTranslate(facing, .5f);
    }
}
