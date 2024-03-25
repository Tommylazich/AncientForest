package net.halocovenet7.ancientforests.datagen;

import net.halocovenet7.ancientforests.AncientForests;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, AncientForests.MODID);
    }

    @Override
    protected void start() {

    }
}
