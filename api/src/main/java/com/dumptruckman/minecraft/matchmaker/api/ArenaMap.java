package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.api.config.MapConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MapRecord;

public interface ArenaMap {
    
    MapConfig config();

    MapRecord record();
}
