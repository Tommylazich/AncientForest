package net.halocovenet7.ancientforests.datagen.loot;

import net.halocovenet7.ancientforests.block.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.NEW_OAK_SAPLING.get());
        this.dropSelf(ModBlocks.OAK_BRANCH.get());
        this.dropSelf(ModBlocks.SPOTTED_GRASS.get());
        this.dropSelf(ModBlocks.LEAF_LITTER.get());

    }


    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
