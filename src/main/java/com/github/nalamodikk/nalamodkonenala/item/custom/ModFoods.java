package com.github.nalamodikk.nalamodkonenala.item.custom;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;


public class ModFoods {

        public static final FoodProperties KIWI = new FoodProperties.Builder()
                .nutrition(2)
                .fast()
                .saturationMod(0.2f)
                .effect(() -> new MobEffectInstance(MobEffects.LUCK, 200), 0.1f) // 第一個效果
                .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 1), 0.2f) // 第二個效果，帶有等級
                .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 300, 2), 0.05f) // 第三個效果，帶有更高的等級
                .build();



}


