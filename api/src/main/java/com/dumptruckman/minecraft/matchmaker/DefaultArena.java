package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.Arena;
import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.LocalWorld;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.Vector2D;
import com.sk89q.worldedit.regions.RegionOperationException;

import java.util.Iterator;
import java.util.Set;

class DefaultArena implements Arena {

    @Override
    public String getName() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setName(String name) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArenaMap getMap() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setMap(ArenaMap map) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArenaConfig config() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public ArenaRecord record() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
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
    public void expand(Vector vector) throws RegionOperationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void expand(Vector... vectors) throws RegionOperationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void contract(Vector vector) throws RegionOperationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void contract(Vector... vectors) throws RegionOperationException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void shift(Vector vector) throws RegionOperationException {
        //To change body of implemented methods use File | Settings | File Templates.
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
    public LocalWorld getWorld() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setWorld(LocalWorld localWorld) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator<BlockVector> iterator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
