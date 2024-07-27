package com.github.nalamodikk.nalamodkonenala.datagen;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;
import com.github.nalamodikk.nalamodkonenala.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
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
        oreSmelting(pWriter, NALA_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.nala_stone.get(), 0.25f, 200, "sapphire");
        oreBlasting(pWriter, NALA_STONE_SMELTABLES, RecipeCategory.MISC, ModItems.nala_stone.get(), 0.25f, 100, "sapphire");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.NALA_STONE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.nala_stone.get())
                .unlockedBy(getHasName(ModItems.nala_stone.get()), has(ModItems.nala_stone.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_NALA_STONE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.raw_nala_stone.get())
                .unlockedBy(getHasName(ModItems.raw_nala_stone.get()), has(ModItems.raw_nala_stone.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.nala_stone.get(), 9)
                .requires(ModBlocks.NALA_STONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NALA_STONE_BLOCK.get()), has(ModBlocks.NALA_STONE_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.raw_nala_stone.get(), 9)
                .requires(ModBlocks.RAW_NALA_STONE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_NALA_STONE_BLOCK.get()), has(ModBlocks.RAW_NALA_STONE_BLOCK.get()))
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