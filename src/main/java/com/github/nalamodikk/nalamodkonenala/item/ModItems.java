package com.github.nalamodikk.nalamodkonenala.item;

import com.github.nalamodikk.nalamodkonenala.Konenalamod;
import com.github.nalamodikk.nalamodkonenala.item.custom.MetalDetectorItem;
import com.github.nalamodikk.nalamodkonenala.item.custom.ModFoods;
import net.minecraft.world.item.*;
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



    public static final RegistryObject<Item> NALA_STONE_SWORD = ITEMS.register("nala_stone_sword",
            () -> new SwordItem(ModToolTiers.NALA_STONE, 5, 2, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_PICKAXE = ITEMS.register("nala_stone_pickaxe",
            () -> new PickaxeItem(ModToolTiers.NALA_STONE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_AXE = ITEMS.register("nala_stone_axe",
            () -> new AxeItem(ModToolTiers.NALA_STONE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_SHOVEL = ITEMS.register("nala_stone_shovel",
            () -> new ShovelItem(ModToolTiers.NALA_STONE, 3, 0, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_HOE = ITEMS.register("nala_stone_hoe",
            () -> new HoeItem(ModToolTiers.NALA_STONE, 4, 0, new Item.Properties()));


    public static final RegistryObject<Item> NALA_STONE_HELMET = ITEMS.register("nala_stone_helmet",
            () -> new ArmorItem(ModArmorMaterials.nala_stone, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_CHESTPLATE = ITEMS.register("nala_stone_chestplate",
            () -> new ArmorItem(ModArmorMaterials.nala_stone, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_LEGGINGS = ITEMS.register("nala_stone_leggings",
            () -> new ArmorItem(ModArmorMaterials.nala_stone, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> NALA_STONE_BOOTS = ITEMS.register("nala_stone_boots",
            () -> new ArmorItem(ModArmorMaterials.nala_stone, ArmorItem.Type.BOOTS, new Item.Properties()));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);

    }

}
