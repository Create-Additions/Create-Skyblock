package mod.kotakotik22.createskyblock.register;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllTileEntities;
import com.simibubi.create.content.contraptions.components.crank.HandCrankInstance;
import com.simibubi.create.content.contraptions.components.crank.HandCrankRenderer;
import com.simibubi.create.content.contraptions.components.crank.HandCrankTileEntity;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.repack.registrate.util.entry.TileEntityEntry;
import mod.kotakotik22.createskyblock.content.gearCrank.GearCrankInstance;
import mod.kotakotik22.createskyblock.content.gearCrank.GearCrankRenderer;
import net.minecraft.tileentity.TileEntity;

public class ModTiles {
    public static TileEntityEntry<HandCrankTileEntity> GEAR_CRANK;

    public static void register(CreateRegistrate registrate) {
        GEAR_CRANK = registrate
                .tileEntity("gear_crank", HandCrankTileEntity::new)
                .instance(() -> GearCrankInstance::new)
                .validBlocks(ModBlocks.GEAR_CRANK)
                .renderer(() -> GearCrankRenderer::new)
                .register();
    }
}
