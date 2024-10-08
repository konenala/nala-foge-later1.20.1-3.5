package com.github.nalamodikk.nalamodkonenala.datagen;


import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;
import com.github.nalamodikk.nalamodkonenala.block.custom.KIWICropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Konenalamod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.NALA_STONE_BLOCK);
        blockWithItem(ModBlocks.RAW_NALA_STONE_BLOCK);

        blockWithItem(ModBlocks.NALA_STONE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_NALA_STONE_ORE);
        blockWithItem(ModBlocks.END_STONE_NALA_STONE_ORE);
        blockWithItem(ModBlocks.NETHER_NALA_STONE_ORE);

        blockWithItem(ModBlocks.TEST_BLOCK);



        stairsBlock(((StairBlock) ModBlocks.NALA_STONE_STAIRS.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.NALA_STONE_SLAB.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.NALA_STONE_BUTTON.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.NALA_STONE_PRESSURE_PLATE.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.NALA_STONE_FENCE.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.NALA_STONE_FENCE_GATE.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.NALA_STONE_WALL.get()), blockTexture(ModBlocks.NALA_STONE_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.NALA_STONE_DOOR.get()), modLoc("block/nala_stone_door_bottom"), modLoc("block/nala_stone_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.NALA_STONE_TRAPDOOR.get()), modLoc("block/nala_stone_trapdoor"), true, "cutout");


        makeStrawberryCrop((CropBlock) ModBlocks.KIWI_CROP.get(), "kiwi_stage", "kiwi_stage");
    }


       // blockWithItem(ModBlocks.XXXXX);
       public void makeStrawberryCrop(CropBlock block, String modelName, String textureName) {
           Function<BlockState, ConfiguredModel[]> function = state -> kiwiStates(state, block, modelName, textureName);

           getVariantBuilder(block).forAllStates(function);
       }

    private ConfiguredModel[] kiwiStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KIWICropBlock) block).getAgeProperty()),
                new ResourceLocation(Konenalamod.MOD_ID, "block/" + textureName + state.getValue(((KIWICropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}