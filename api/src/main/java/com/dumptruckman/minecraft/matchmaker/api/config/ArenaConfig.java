package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;
import com.sk89q.worldedit.Vector;

/**
 * Contains the configuration for a single arena.
 */
public interface ArenaConfig extends Config<ArenaConfig> {
    
    ConfigEntry<String> NAME = new SimpleConfigEntry<String>(String.class, "name", null);

    ConfigEntry<Integer> MIN_X = new SimpleConfigEntry<Integer>(Integer.class, "location.min.x", null);
    ConfigEntry<Integer> MIN_Y = new SimpleConfigEntry<Integer>(Integer.class, "location.min.y", null);
    ConfigEntry<Integer> MIN_Z = new SimpleConfigEntry<Integer>(Integer.class, "location.min.z", null);

    ConfigEntry<Integer> MAX_X = new SimpleConfigEntry<Integer>(Integer.class, "location.max.x", null);
    ConfigEntry<Integer> MAX_Y = new SimpleConfigEntry<Integer>(Integer.class, "location.max.y", null);
    ConfigEntry<Integer> MAX_Z = new SimpleConfigEntry<Integer>(Integer.class, "location.max.z", null);
    
    ConfigEntry<String> WORLD = new SimpleConfigEntry<String>(String.class, "location.world", null);
}
