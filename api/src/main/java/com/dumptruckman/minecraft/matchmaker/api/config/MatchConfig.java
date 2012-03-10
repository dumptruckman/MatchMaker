package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;

/**
 * Contains the configuration for a single match.
 */
public interface MatchConfig extends Config {
    
    ConfigEntry<Integer> MAX_ROUNDS = new SimpleConfigEntry<Integer>(Integer.class, "rounds.max", 3);

    /**
     * Time limit for each round in seconds. 0 means no limit
     */
    ConfigEntry<Integer> TIME_LIMIT = new SimpleConfigEntry<Integer>(Integer.class, "rounds.time_limit", 0);
    
    ConfigEntry<Integer> MAX_TEAMS = new SimpleConfigEntry<Integer>(Integer.class, "teams.max", 2);

    ConfigEntry<Integer> TEAM_SIZE = new SimpleConfigEntry<Integer>(Integer.class, "teams.size", 4);
    
    ConfigEntry<Integer> MAX_LIVES = new SimpleConfigEntry<Integer>(Integer.class, "lives.max", 3);

    ConfigEntry<Boolean> TEAM_LIVES = new SimpleConfigEntry<Boolean>(Boolean.class, "lives.team", false);
    

}
