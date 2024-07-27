package com.github.nalamodikk.nalamodkonenala.block;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Konenalamod.MOD_ID);

    public static final RegistryObject<Block> NALA_STONE_BLOCK = registerBlock("nala_stone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> RAW_NALA_STONE_BLOCK = registerBlock("raw_nala_stone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.STONE)));




    public static final RegistryObject<Block> NALA_STONE_ORE = registerBlock("nala_stone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> DEEPSLATE_NALA_STONE_ORE = registerBlock("deepslate_nala_stone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> NETHER_NALA_STONE_ORE = registerBlock("nether_nala_stone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));
    public static final RegistryObject<Block> END_STONE_NALA_STONE_ORE = registerBlock("end_stone_nala_stone_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(7f).requiresCorrectToolForDrops(), UniformInt.of(3, 7)));



    public static final RegistryObject<Block> NALA_STONE_STAIRS = registerBlock("nala_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.NALA_STONE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> NALA_STONE_SLAB = registerBlock("nala_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> NALA_STONE_BUTTON = registerBlock("nala_stone_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.METAL),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> NALA_STONE_PRESSURE_PLATE = registerBlock("nala_stone_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL),
                    BlockSetType.IRON));

    public static final RegistryObject<Block> NALA_STONE_FENCE = registerBlock("nala_stone_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));
    public static final RegistryObject<Block> NALA_STONE_FENCE_GATE = registerBlock("nala_stone_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL), SoundEvents.FENCE_GATE_OPEN, SoundEvents.ANVIL_BREAK));
    public static final RegistryObject<Block> NALA_STONE_WALL = registerBlock("nala_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    public static final RegistryObject<Block> NALA_STONE_DOOR = registerBlock("nala_stone_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).noOcclusion(), BlockSetType.IRON));
    public static final RegistryObject<Block> NALA_STONE_TRAPDOOR = registerBlock("nala_stone_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL).noOcclusion(), BlockSetType.IRON));





    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get() ,new Item.Properties()));


    }




    public static void register (IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
