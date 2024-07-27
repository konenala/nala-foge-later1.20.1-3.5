package com.github.nalamodikk.nalamodkonenala.datagen;


import com.github.nalamodikk.nalamodkonenala.item.ModItems;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;
import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Konenalamod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.nala_stone);
        simpleItem(ModItems.raw_nala_stone);

        simpleItem(ModItems.METAL_DETECTOR);

        simpleItem(ModItems.KIWI);

        simpleBlockItem(ModBlocks.NALA_STONE_DOOR);

        fenceItem(ModBlocks.NALA_STONE_FENCE, ModBlocks.NALA_STONE_BLOCK);
        buttonItem(ModBlocks.NALA_STONE_BUTTON, ModBlocks.NALA_STONE_BLOCK);
        wallItem(ModBlocks.NALA_STONE_WALL, ModBlocks.NALA_STONE_BLOCK);

        evenSimplerBlockItem(ModBlocks.NALA_STONE_STAIRS);
        evenSimplerBlockItem(ModBlocks.NALA_STONE_SLAB);
        evenSimplerBlockItem(ModBlocks.NALA_STONE_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.NALA_STONE_FENCE_GATE);

        trapdoorItem(ModBlocks.NALA_STONE_TRAPDOOR);
        // simpleItem(ModItems.xxxxx);
        //simpleItem(ModItems.STRAWBERRY);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Konenalamod.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(Konenalamod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Konenalamod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(Konenalamod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(Konenalamod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Konenalamod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
