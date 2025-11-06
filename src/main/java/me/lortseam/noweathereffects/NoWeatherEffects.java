package me.lortseam.noweathereffects;

import me.lortseam.noweathereffects.config.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class NoWeatherEffects implements ClientModInitializer {

    private static ModConfig CONFIG;

    @Override
    public void onInitializeClient() {
        if (FabricLoader.getInstance().isModLoaded("cloth-config2")) {
            AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
            CONFIG = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        }
    }

    public static boolean isEnabled() {
        return CONFIG == null || CONFIG.toggleWeather;
    }
}