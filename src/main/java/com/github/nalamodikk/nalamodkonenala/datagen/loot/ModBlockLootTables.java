package com.github.nalamodikk.nalamodkonenala.datagen.loot;

import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;
import com.github.nalamodikk.nalamodkonenala.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.NALA_STONE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_NALA_STONE_BLOCK.get());
        // this.dropSelf(ModBlocks.XXXXXXX.get());

        this.add(ModBlocks.NALA_STONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NALA_STONE_ORE.get(), ModItems.raw_nala_stone.get()));
        this.add(ModBlocks.DEEPSLATE_NALA_STONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_NALA_STONE_ORE.get(), ModItems.raw_nala_stone.get()));
        this.add(ModBlocks.NETHER_NALA_STONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.NETHER_NALA_STONE_ORE.get(), ModItems.raw_nala_stone.get()));
        this.add(ModBlocks.END_STONE_NALA_STONE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.END_STONE_NALA_STONE_ORE.get(), ModItems.raw_nala_stone.get()));

        this.dropSelf(ModBlocks.NALA_STONE_STAIRS.get());
        this.dropSelf(ModBlocks.NALA_STONE_BUTTON.get());
        this.dropSelf(ModBlocks.NALA_STONE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.NALA_STONE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.NALA_STONE_FENCE.get());
        this.dropSelf(ModBlocks.NALA_STONE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.NALA_STONE_WALL.get());

        this.add(ModBlocks.NALA_STONE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.NALA_STONE_SLAB.get()));
        this.add(ModBlocks.NALA_STONE_DOOR.get(),
                block -> createDoorTable(ModBlocks.NALA_STONE_DOOR.get()));


    }


    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}