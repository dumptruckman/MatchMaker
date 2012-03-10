package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.block.Blocks;
import com.dumptruckman.minecraft.matchmaker.api.block.LocalBlock;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.dumptruckman.minecraft.matchmaker.api.config.MapConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MapRecord;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.regions.Region;

import java.util.Iterator;

class DefaultMap extends DefaultRegion<MapConfig> implements ArenaMap {
    
    private Config<MapRecord> record;
    private Blocks blocks;

    DefaultMap(Config<MapConfig> config, Config<MapRecord> record) {
        super(config);
        this.record = record;
        this.blocks = config.get(MapConfig.BLOCKS);
    }

    DefaultMap(String name, Region region, Blocks blocks, Config<MapConfig> config, Config<MapRecord> record) {
        super(region, config);
        this.record = record;
        this.blocks = blocks;
        config.set(MapConfig.NAME, name);
        config.set(MapConfig.BLOCKS, blocks);
        Vector min = region.getMinimumPoint();
        Vector max = region.getMaximumPoint();
        config.set(ArenaConfig.MAX_X, max.getBlockX() - min.getBlockX());
        config.set(ArenaConfig.MAX_Y, max.getBlockY() - min.getBlockY());
        config.set(ArenaConfig.MAX_Z, max.getBlockZ() - min.getBlockZ());
        config.set(ArenaConfig.MIN_X, 0);
        config.set(ArenaConfig.MIN_Y, 0);
        config.set(ArenaConfig.MIN_Z, 0);
        config.save();
    }
    
    public String getName() {
        return config().get(MapConfig.NAME);
    }

    @Override
    public Blocks getBlocks() {
        return blocks;
    }

    @Override
    public Config<MapRecord> record() {
        return record;
    }

    @Override
    public void save() {
        config().save();
        record().save();
    }

    @Override
    public Iterator<LocalBlock> iterator() {
        return blocks.iterator();
    }
}
