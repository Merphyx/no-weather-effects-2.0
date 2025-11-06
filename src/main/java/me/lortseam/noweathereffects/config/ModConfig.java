package me.lortseam.noweathereffects.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "noweathereffects")
public class ModConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean toggleWeather = true;
}