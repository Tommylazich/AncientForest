package net.halocovenet7.ancientforests.worldgen;

import net.halocovenet7.ancientforests.AncientForests;
import net.halocovenet7.ancientforests.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SAPPHIRE_ORE_PLACED_KEY = registerKey("sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SAPPHIRE_ORE_PLACED_KEY = registerKey("nether_sapphire_ore_placed");
    public static final ResourceKey<PlacedFeature> END_SAPPHIRE_ORE_PLACED_KEY = registerKey("end_sapphire_ore_placed");

    public static final ResourceKey<PlacedFeature> NEW_OAK_PLACED = registerKey("new_oak_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);



        register(context, NEW_OAK_PLACED, configuredFeatures.getOrThrow(ModConfiguredFeatures.NEW_OAK_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(3, 0.1f, 2),
                        ModBlocks.NEW_OAK_SAPLING.get()));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(AncientForests.MODID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
