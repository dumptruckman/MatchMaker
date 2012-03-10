package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;
import com.sk89q.worldedit.Vector;

/**
 * Contains the configuration for a single arena.
 */
public interface ArenaConfig extends RegionConfig<ArenaConfig> {
    
    ConfigEntry<String> NAME = new SimpleConfigEntry<String>(String.class, "name", "");

    ConfigEntry<String> WORLD = new SimpleConfigEntry<String>(String.class, "world", null);
}
