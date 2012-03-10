package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.Vector2D;

import java.util.Iterator;
import java.util.Set;

/**
 * Represents a single Arena location in the world.
 */
public interface Arena {
    
    String getName();
    
    void setName(String name);
    
    ArenaMap getMap();
    
    void setMap(ArenaMap map);
    
    Config<ArenaConfig> config();
    
    Config<ArenaRecord> record();

    /**
     * Re-caches the Arena data from persistence.
     */
    void refresh();

    public Vector getMinimumPoint();

    public Vector getMaximumPoint();

    public int getArea();

    public int getWidth();

    public int getHeight();

    public int getLength();

    public boolean contains(Vector vector);

    public Set<Vector2D> getChunks();

    public String getWorld();

    public void setWorld(String localWorld);

    public Iterator<BlockVector> iterator();
}
