package mod.kotakotik22.createskyblock.register;

import com.simibubi.create.AllItems;
import com.simibubi.create.foundation.data.CreateRegistrate;
import mod.kotakotik22.createskyblock.BuildConfig;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItems {
    public static ItemGroup itemGroup = new ItemGroup(BuildConfig.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(AllItems.WRENCH.get());
        }
    };

    public static void register(CreateRegistrate registrate) {
        registrate.itemGroup(()->itemGroup, "Create Skyblock");
    }
}
