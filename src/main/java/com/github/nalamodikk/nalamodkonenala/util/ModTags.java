package com.github.nalamodikk.nalamodkonenala.util;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");




        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Konenalamod.MOD_ID, name));
    }
    public static class Items{
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Konenalamod.MOD_ID, name));
            }
        }
    }
}
