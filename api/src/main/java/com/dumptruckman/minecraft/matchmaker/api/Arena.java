package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.sk89q.worldedit.regions.Region;

import java.util.Iterator;

/**
 * Represents a single Arena location in the world.
 */
public interface Arena extends Region {
    
    String getName();
    
    void setName(String name);
    
    ArenaMap getMap();
    
    void setMap(ArenaMap map);
    
    ArenaConfig config();
    
    ArenaRecord record();
}
