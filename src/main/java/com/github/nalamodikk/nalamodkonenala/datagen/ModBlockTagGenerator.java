package com.github.nalamodikk.nalamodkonenala.datagen;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;

import com.github.nalamodikk.nalamodkonenala.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Konenalamod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.NALA_STONE_ORE.get())
                .add(ModBlocks.DEEPSLATE_NALA_STONE_ORE.get())
                .add(ModBlocks.END_STONE_NALA_STONE_ORE.get())
                .add(ModBlocks.NETHER_NALA_STONE_ORE.get())
                .addTag(Tags.Blocks.ORES);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.NALA_STONE_BLOCK.get(),
                        ModBlocks.RAW_NALA_STONE_BLOCK.get(),



                        ModBlocks.NALA_STONE_ORE.get(),
                        ModBlocks.NETHER_NALA_STONE_ORE.get(),
                        ModBlocks.DEEPSLATE_NALA_STONE_ORE.get(),
                        ModBlocks.END_STONE_NALA_STONE_ORE.get(),



                        ModBlocks.NALA_STONE_TRAPDOOR.get(),
                        ModBlocks.NALA_STONE_DOOR.get(),
                        ModBlocks.NALA_STONE_WALL.get(),
                        ModBlocks.NALA_STONE_FENCE_GATE.get(),
                        ModBlocks.NALA_STONE_FENCE.get(),
                        ModBlocks.NALA_STONE_PRESSURE_PLATE.get(),
                        ModBlocks.NALA_STONE_BUTTON.get(),
                        ModBlocks.NALA_STONE_SLAB.get(),
                        ModBlocks.NALA_STONE_STAIRS.get());

                       // ModBlocks.SOUND_BLOCK.get());


        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.NALA_STONE_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_NALA_STONE_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.NETHER_NALA_STONE_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlocks.END_STONE_NALA_STONE_ORE.get());


        this.tag(ModTags.Blocks.NEEDS_NALA_STONE_TOOL)
                .add(ModBlocks.TEST_BLOCK.get());




        this.tag(BlockTags.FENCES)
                .add(ModBlocks.NALA_STONE_FENCE.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.NALA_STONE_FENCE_GATE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.NALA_STONE_WALL.get());
    }
}