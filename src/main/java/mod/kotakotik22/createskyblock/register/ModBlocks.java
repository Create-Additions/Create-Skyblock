package mod.kotakotik22.createskyblock.register;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.contraptions.components.crank.HandCrankBlock;
import com.simibubi.create.foundation.block.ItemUseOverrides;
import com.simibubi.create.foundation.config.StressConfigDefaults;
import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.repack.registrate.util.entry.BlockEntry;
import com.simibubi.create.repack.registrate.util.entry.TileEntityEntry;
import com.simibubi.create.repack.registrate.util.nullness.NonNullSupplier;
import mod.kotakotik22.createskyblock.content.gearCrank.GearCrankBlock;
import net.minecraft.block.Block;

public class ModBlocks {
    public static BlockEntry<GearCrankBlock> GEAR_CRANK;

    public static void register(CreateRegistrate registrate) {
        GEAR_CRANK = registrate.block("gear_crank", GearCrankBlock::new)
                .initialProperties(SharedProperties::wooden)
                .blockstate(BlockStateGen.directionalBlockProvider(false))
                .transform(StressConfigDefaults.setCapacity(8.0))
                .tag(AllTags.AllBlockTags.BRITTLE.tag)
                .simpleItem()
                .onRegister(ItemUseOverrides::addBlock)
                .register();
    }
}
