package com.github.nalamodikk.nalamodkonenala.item;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier NALA_STONE = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 4f, 4f, 25,
                    ModTags.Blocks.NEEDS_NALA_STONE_TOOL, () -> Ingredient.of(ModItems.nala_stone.get())),
            new ResourceLocation(Konenalamod.MOD_ID, "nala_stone"), List.of(Tiers.NETHERITE), List.of());

}
