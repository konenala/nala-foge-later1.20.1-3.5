package com.github.nalamodikk.nalamodkonenala.item;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreative {
public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Konenalamod.MOD_ID);

public static final RegistryObject<CreativeModeTab> KONENALAMOD_TAB = CREATIVE_MODE_TABS.register("konenalamod.tab",
        () -> CreativeModeTab.builder().icon( () -> new ItemStack(ModItems.nala_stone.get()))
                .title(Component.translatable("creativetab.konenalamod_tab"))
                .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.nala_stone.get());
                        pOutput.accept(ModItems.raw_nala_stone.get());

                        pOutput.accept(ModItems.METAL_DETECTOR.get());



                        pOutput.accept(ModBlocks.NALA_STONE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_NALA_STONE_BLOCK.get());

                        pOutput.accept(ModBlocks.NALA_STONE_TRAPDOOR.get());
                        pOutput.accept(ModBlocks.NALA_STONE_DOOR.get());
                        pOutput.accept(ModBlocks.NALA_STONE_WALL.get());
                        pOutput.accept(ModBlocks.NALA_STONE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.NALA_STONE_FENCE.get());
                        pOutput.accept(ModBlocks.NALA_STONE_PRESSURE_PLATE.get());
                        pOutput.accept(ModBlocks.NALA_STONE_BUTTON.get());
                        pOutput.accept(ModBlocks.NALA_STONE_SLAB.get());
                        pOutput.accept(ModBlocks.NALA_STONE_STAIRS.get());


                        pOutput.accept(ModBlocks.NALA_STONE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_NALA_STONE_ORE.get());
                        pOutput.accept(ModBlocks.NETHER_NALA_STONE_ORE.get());
                        pOutput.accept(ModBlocks.END_STONE_NALA_STONE_ORE.get());


                        pOutput.accept(ModItems.KIWI.get());

                        pOutput.accept(Items.DIAMOND);

                })
                .build());

public static void register(IEventBus eventBus) {
    CREATIVE_MODE_TABS.register(eventBus);

}

}
