package com.github.nalamodikk.nalamodkonenala.worldgen;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;
public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> NALA_STONE_ORE_PLACED_KEY = registerKey("nala_stone_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_NALA_STONE_ORE_PLACED_KEY = registerKey("nether_nala_stone_ore_placed");
    public static final ResourceKey<PlacedFeature> END_NALA_STONE_ORE_PLACED_KEY = registerKey("end_nala_stone_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, NALA_STONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_NALA_STONE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, NETHER_NALA_STONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_NALA_STONE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
        register(context, END_NALA_STONE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_NALA_STONE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Konenalamod.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
