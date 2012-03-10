package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.BaseConfig;
import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;

public interface MMConfig extends BaseConfig {

    ConfigEntry<String> EXAMPLE = new SimpleConfigEntry<String>(String.class, "path.to.entry", "default", "# comments");
}
