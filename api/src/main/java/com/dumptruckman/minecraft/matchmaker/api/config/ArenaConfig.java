package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.Config;
import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;
import com.sk89q.worldedit.Vector;

/**
 * Contains the configuration for a single arena.
 */
public interface ArenaConfig extends Config {

    ConfigEntry<Vector> MIN_POINT = new VectorEntry("location.min_point", null);

    ConfigEntry<Vector> MAX_POINT = new VectorEntry("location.max_point", null);
    
    ConfigEntry<String> WORLD = new SimpleConfigEntry<String>(String.class, "location.world", null);
}
