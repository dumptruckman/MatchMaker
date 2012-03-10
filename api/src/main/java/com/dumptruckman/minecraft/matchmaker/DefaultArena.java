package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.Arena;
import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.Vector2D;
import com.sk89q.worldedit.bukkit.selections.Selection;

import java.util.Iterator;
import java.util.Set;

class DefaultArena implements Arena {
    
    private String name;
    private ArenaMap map = null;
    
    private Config<ArenaConfig> config;
    private Config<ArenaRecord> record;
    
    private Vector min;
    private Vector max;

    DefaultArena(String name, Selection selection, Config<ArenaConfig> config, Config<ArenaRecord> record) {
        this.name = name;
        this.config = config;
        this.record = record;
        config.set(ArenaConfig.MIN_POINT, selection.getNativeMinimumPoint());
        config.set(ArenaConfig.MAX_POINT, selection.getNativeMaximumPoint());
        
        reloadFromConfig();
    }

    private void reloadFromConfig() {
        this.min = config.get(ArenaConfig.MIN_POINT);
        this.max = config.get(ArenaConfig.MAX_POINT);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public ArenaMap getMap() {
        return map;
    }

    @Override
    public void setMap(ArenaMap map) {
        this.map = map;
    }

    @Override
    public Config<ArenaConfig> config() {
        return config;
    }

    @Override
    public Config<ArenaRecord> record() {
        return record;
    }

    @Override
    public void refresh() {
        reloadFromConfig();
    }

    @Override
    public Vector getMinimumPoint() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Vector getMaximumPoint() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getArea() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getWidth() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getHeight() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getLength() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean contains(Vector vector) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Vector2D> getChunks() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getWorld() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWorld(String localWorld) {

    }

    @Override
    public Iterator<BlockVector> iterator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
