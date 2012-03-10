package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.api.block.Blocks;
import com.dumptruckman.minecraft.matchmaker.api.block.LocalBlock;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.dumptruckman.minecraft.matchmaker.api.config.MapConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MapRecord;

public interface ArenaMap extends MMRegion<MapConfig>, Iterable<LocalBlock> {
    
    String getName();

    Config<MapRecord> record();

    Blocks getBlocks();

    /**
     * Saves the Map data to database.
     */
    void save();
}
