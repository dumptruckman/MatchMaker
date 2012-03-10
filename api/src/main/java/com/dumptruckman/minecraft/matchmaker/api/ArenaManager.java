package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.Arenas;
import com.sk89q.worldedit.regions.Region;

import java.io.IOException;

public interface ArenaManager {
    
    Arena getArena(String name);

    Arenas getArenas();

    Arena getIntersectingArena(Region region);

    Arena newArena(String name, Region region) throws IllegalArgumentException, IOException;
    
    void loadArenas() throws IOException;
}
