package mod.kotakotik22.createskyblock.content.gearCrank;

import com.jozufozu.flywheel.backend.instancing.Instancer;
import com.jozufozu.flywheel.backend.instancing.MaterialManager;
import com.jozufozu.flywheel.core.PartialModel;
import com.jozufozu.flywheel.core.materials.ModelData;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.simibubi.create.content.contraptions.components.crank.HandCrankBlock;
import com.simibubi.create.content.contraptions.components.crank.HandCrankInstance;
import com.simibubi.create.content.contraptions.components.crank.HandCrankTileEntity;
import com.simibubi.create.foundation.utility.AnimationTickHolder;
import com.simibubi.create.foundation.utility.MatrixStacker;
import mod.kotakotik22.createskyblock.register.ModBlocks;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class GearCrankInstance extends HandCrankInstance {
    public static Field thE_CRANK_IS_PRIVATE = ObfuscationReflectionHelper.findField(HandCrankInstance.class, "crank");
    public final Direction facing;
    public final HandCrankTileEntity tile;

    public GearCrankInstance(MaterialManager<?> modelManager, HandCrankTileEntity tile) {
        super(modelManager, tile);
        this.tile = tile;
        this.facing = this.blockState.getValue(BlockStateProperties.FACING);
    }

    @Override
    public void beginFrame() {
        rotateCrank();
    }

    public void rotateCrank() {
        Direction.Axis axis = facing.getAxis();
        float angle = (tile.independentAngle + AnimationTickHolder.getPartialTicks() * this.tile.chasingVelocity) / 360.0F;
        MatrixStack ms = new MatrixStack();
        MatrixStacker.of(ms).translate(this.getInstancePosition()).translate(ModBlocks.GEAR_CRANK.get().getCrankRenderTranslate(facing)).centre().rotate(Direction.get(Direction.AxisDirection.POSITIVE, axis), angle).unCentre();
        try { // this pains me
            ((ModelData) thE_CRANK_IS_PRIVATE.get(this)).setTransform(ms);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
