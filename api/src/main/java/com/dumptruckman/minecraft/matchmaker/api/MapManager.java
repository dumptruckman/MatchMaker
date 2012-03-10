package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.Maps;
import com.sk89q.worldedit.regions.Region;

import java.io.IOException;

/**
 * Handles management of maps: Saving, Loading, Search, Instancing, etc.
 */
public interface MapManager {
    
    ArenaMap getMap(String name);
    
    Maps getMaps();

    ArenaMap newMap(String name, Region region) throws IllegalArgumentException, IOException;
}
