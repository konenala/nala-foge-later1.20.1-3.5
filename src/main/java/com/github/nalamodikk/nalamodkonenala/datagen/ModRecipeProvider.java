package com.github.nalamodikk.nalamodkonenala.datagen;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;
import com.github.nalamodikk.nalamodkonenala.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> NALA_STONE_SMELTABLES = List.of(ModItems.raw_nala_stone.get(),
            ModBlocks.NALA_STONE_ORE.get(), ModBlocks.DEEPSLATE_NALA_STONE_ORE.get(), ModBlocks.NETHER_NALA_STONE_ORE.get(),
            ModBlocks.END_STONE_NALA_STONE_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }



    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // 定義熔煉與爆炸熔煉配方
        createOreProcessingRecipes(pWriter, NALA_STONE_SMELTABLES, ModItems.nala_stone.get(), "nala_stone");

        // 定義方塊與物品的合成配方
        createBlockRecipe(pWriter, ModItems.nala_stone.get(), ModBlocks.NALA_STONE_BLOCK.get(), "nala_stone_block");
        createBlockRecipe(pWriter, ModItems.raw_nala_stone.get(), ModBlocks.RAW_NALA_STONE_BLOCK.get(), "raw_nala_stone_block");

        // 定義工具配方
        createToolRecipe(pWriter, ModItems.NALA_STONE_PICKAXE.get(), "MMM", " S ", " S ", ModItems.nala_stone.get(), Items.STICK, "nala_stone_pickaxe");
        createToolRecipe(pWriter, ModItems.NALA_STONE_AXE.get(), "MM ", "MS ", " S ", ModItems.nala_stone.get(), Items.STICK, "nala_stone_axe");
        createToolRecipe(pWriter, ModItems.NALA_STONE_HOE.get(), "MM ", " S ", " S ", ModItems.nala_stone.get(), Items.STICK, "nala_stone_hoe");
        createToolRecipe(pWriter, ModItems.NALA_STONE_SHOVEL.get(), " M ", " S ", " S ", ModItems.nala_stone.get(), Items.STICK, "nala_stone_shovel");
        createToolRecipe(pWriter, ModItems.NALA_STONE_SWORD.get(), " M ", " M ", " S ", ModItems.nala_stone.get(), Items.STICK, "nala_stone_sword");

        // 定義盔甲配方
        createArmorRecipe(pWriter, ModItems.NALA_STONE_HELMET.get(), "MMM", "M M", "   ", ModItems.nala_stone.get(), "nala_stone_helmet");
        createArmorRecipe(pWriter, ModItems.NALA_STONE_CHESTPLATE.get(), "M M", "MMM", "MMM", ModItems.nala_stone.get(), "nala_stone_chestplate");
        createArmorRecipe(pWriter, ModItems.NALA_STONE_LEGGINGS.get(), "MMM", "M M", "M M", ModItems.nala_stone.get(), "nala_stone_leggings");
        createArmorRecipe(pWriter, ModItems.NALA_STONE_BOOTS.get(), "M M", "M M", "   ", ModItems.nala_stone.get(), "nala_stone_boots");
    }

    // 創建熔煉與爆炸熔煉配方的輔助方法
    private void createOreProcessingRecipes(Consumer<FinishedRecipe> pWriter, List<ItemLike> smeltables, ItemLike result, String group) {
        oreSmelting(pWriter, smeltables, RecipeCategory.MISC, result, 0.25f, 200, group);
        oreBlasting(pWriter, smeltables, RecipeCategory.MISC, result, 0.25f, 100, group);
    }

    // 創建方塊與物品合成配方的輔助方法
    private void createBlockRecipe(Consumer<FinishedRecipe> pWriter, ItemLike material, ItemLike block, String group) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', material)
                .unlockedBy(getHasName(material), has(material))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, material, 9)
                .requires(block)
                .unlockedBy(getHasName(block), has(block))
                .save(pWriter);
    }

    // 創建工具合成配方的輔助方法
    private void createToolRecipe(Consumer<FinishedRecipe> pWriter, ItemLike tool, String top, String middle, String bottom, ItemLike material, ItemLike stick, String group) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, tool)
                .pattern(top)
                .pattern(middle)
                .pattern(bottom)
                .define('M', material)
                .define('S', stick)
                .unlockedBy("has_material", has(material))
                .save(pWriter);
    }

    // 創建盔甲合成配方的輔助方法
    private void createArmorRecipe(Consumer<FinishedRecipe> pWriter, ItemLike armor, String top, String middle, String bottom, ItemLike material, String group) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, armor)
                .pattern(top)
                .pattern(middle)
                .pattern(bottom)
                .define('M', material)
                .unlockedBy("has_material", has(material))
                .save(pWriter);

}

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  Konenalamod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}