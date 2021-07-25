package mod.kotakotik22.createskyblock.content.gearCrank;

import com.jozufozu.flywheel.backend.Backend;
import com.jozufozu.flywheel.core.PartialModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.simibubi.create.content.contraptions.base.KineticTileEntity;
import com.simibubi.create.content.contraptions.base.KineticTileEntityRenderer;
import com.simibubi.create.content.contraptions.components.crank.HandCrankBlock;
import com.simibubi.create.content.contraptions.components.crank.HandCrankRenderer;
import com.simibubi.create.content.contraptions.components.crank.HandCrankTileEntity;
import com.simibubi.create.foundation.render.PartialBufferer;
import com.simibubi.create.foundation.render.SuperByteBuffer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;

public class GearCrankRenderer extends KineticTileEntityRenderer {
    public GearCrankRenderer(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    protected void renderSafe(KineticTileEntity te, float partialTicks, MatrixStack ms, IRenderTypeBuffer buffer, int light, int overlay) {
        super.renderSafe(te, partialTicks, ms, buffer, light, overlay);
        if (!Backend.getInstance().canUseInstancing(te.getLevel())) {
            BlockState state = te.getBlockState();
            GearCrankBlock block = (GearCrankBlock) state.getBlock();
            PartialModel renderedHandle = block.getRenderedHandle();

            if (renderedHandle != null) {
                Direction facing = state.getValue(BlockStateProperties.FACING);
                SuperByteBuffer handle = PartialBufferer.getFacing(renderedHandle, state, facing.getOpposite());
                HandCrankTileEntity crank = (HandCrankTileEntity)te;
                kineticRotationTransform(handle, te, facing.getAxis(), (crank.independentAngle + partialTicks * crank.chasingVelocity) / 360.0F, light);
                handle.translate(block.getCrankRenderTranslate(facing)).renderInto(ms, buffer.getBuffer(RenderType.solid()));
            }
        }
    }
}
