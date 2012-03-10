package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;

public interface RegionConfig<V extends RegionConfig> extends Config<V> {

    ConfigEntry<Integer> MIN_X = new SimpleConfigEntry<Integer>(Integer.class, "min.x", null);
    ConfigEntry<Integer> MIN_Y = new SimpleConfigEntry<Integer>(Integer.class, "min.y", null);
    ConfigEntry<Integer> MIN_Z = new SimpleConfigEntry<Integer>(Integer.class, "min.z", null);

    ConfigEntry<Integer> MAX_X = new SimpleConfigEntry<Integer>(Integer.class, "max.x", null);
    ConfigEntry<Integer> MAX_Y = new SimpleConfigEntry<Integer>(Integer.class, "max.y", null);
    ConfigEntry<Integer> MAX_Z = new SimpleConfigEntry<Integer>(Integer.class, "max.z", null);
}
