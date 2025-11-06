package me.lortseam.noweathereffects.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.NoticeScreen;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (FabricLoader.getInstance().isModLoaded("cloth-config2")) {
            return parent -> AutoConfig.getConfigScreen(ModConfig.class, parent).get();
        }

        return parent -> new NoticeScreen(
                () -> MinecraftClient.getInstance().setScreen(parent),
                Text.literal("§n§lInfo"),
                Text.translatable("configscreen.noweathereffects.info")
        );
    }
}