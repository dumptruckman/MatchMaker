package com.dumptruckman.minecraft.matchmaker.api;

/**
 * Handles management of maps: Saving, Loading, Search, Instancing, etc.
 */
public interface MapManager {
    
    ArenaMap getMap(String name);
}
