package com.github.nalamodikk.nalamodkonenala.item;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.item.custom.MetalDetectorItem;
import com.github.nalamodikk.nalamodkonenala.item.custom.ModFoods;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Konenalamod.MOD_ID);

    public static final RegistryObject<Item> nala_stone = ITEMS.register("nala_stone" ,
        () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> raw_nala_stone = ITEMS.register("raw_nala_stone" ,
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector" ,
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));

    public static final RegistryObject<Item> KIWI = ITEMS.register("kiwi",
            () -> new Item(new Item.Properties().food(ModFoods.KIWI)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
