package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.Arenas;
import com.sk89q.worldedit.bukkit.selections.Selection;

import java.io.IOException;

public interface ArenaManager {
    
    Arena getArena(String name);

    Arenas getArenas();

    Arena getIntersectingArena(Selection selection);

    public Arena newArena(String name, Selection selection) throws IllegalArgumentException, IOException;
}
