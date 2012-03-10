package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.Arena;
import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.Vector2D;
import com.sk89q.worldedit.data.ChunkStore;
import com.sk89q.worldedit.regions.Region;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class DefaultArena implements Arena {
    
    private ArenaMap map = null;
    
    private Config<ArenaConfig> config;
    private Config<ArenaRecord> record;

    DefaultArena(Config<ArenaConfig> config, Config<ArenaRecord> record) {
        this.config = config;
        this.record = record;
    }

    DefaultArena(String name, Region region, Config<ArenaConfig> config, Config<ArenaRecord> record) {
        this.config = config;
        this.record = record;
        config.set(ArenaConfig.NAME, name);
        Vector min = region.getMinimumPoint();
        Vector max = region.getMaximumPoint();
        config.set(ArenaConfig.MIN_X, min.getBlockX());
        config.set(ArenaConfig.MIN_Y, min.getBlockY());
        config.set(ArenaConfig.MIN_Z, min.getBlockZ());
        config.set(ArenaConfig.MAX_X, max.getBlockX());
        config.set(ArenaConfig.MAX_Y, max.getBlockY());
        config.set(ArenaConfig.MAX_Z, max.getBlockZ());
        config.set(ArenaConfig.WORLD, region.getWorld().getName());
        config.save();
    }

    @Override
    public String getName() {
        return config().get(ArenaConfig.NAME);
    }

    @Override
    public void setName(String name) {
        config.set(ArenaConfig.NAME, name);
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
    public void save() {
        config.save();
    }

    @Override
    public Vector getMinimumPoint() {
        return new Vector(config().get(ArenaConfig.MIN_X), config().get(ArenaConfig.MIN_Y), config().get(ArenaConfig.MIN_Z));
    }

    @Override
    public Vector getMaximumPoint() {
        return new Vector(config().get(ArenaConfig.MAX_X), config().get(ArenaConfig.MAX_Y), config().get(ArenaConfig.MAX_Z));
    }

    @Override
    public int getArea() {
        Vector min = getMinimumPoint();
        Vector max = getMaximumPoint();
        return (int)((max.getX() - min.getX() + 1) *
                (max.getY() - min.getY() + 1) *
                (max.getZ() - min.getZ() + 1));
    }

    @Override
    public int getWidth() {
        Vector min = getMinimumPoint();
        Vector max = getMaximumPoint();
        return (int) (max.getX() - min.getX() + 1);
    }

    @Override
    public int getHeight() {
        Vector min = getMinimumPoint();
        Vector max = getMaximumPoint();
        return (int) (max.getY() - min.getY() + 1);
    }

    @Override
    public int getLength() {
        Vector min = getMinimumPoint();
        Vector max = getMaximumPoint();
        return (int) (max.getZ() - min.getZ() + 1);
    }

    @Override
    public boolean contains(Vector vector) {
        double x = vector.getX();
        double y = vector.getY();
        double z = vector.getZ();

        Vector min = getMinimumPoint();
        Vector max = getMaximumPoint();

        return x >= min.getBlockX() && x <= max.getBlockX()
                && y >= min.getBlockY() && y <= max.getBlockY()
                && z >= min.getBlockZ() && z <= max.getBlockZ();
    }

    @Override
    public Set<Vector2D> getChunks() {
        Set<Vector2D> chunks = new HashSet<Vector2D>();

        Vector min = getMinimumPoint();
        Vector max = getMaximumPoint();

        for (int x = min.getBlockX(); x <= max.getBlockX(); ++x) {
            for (int y = min.getBlockY(); y <= max.getBlockY(); ++y) {
                for (int z = min.getBlockZ(); z <= max.getBlockZ(); ++z) {
                    Vector pt = new Vector(x, y, z);
                    chunks.add(ChunkStore.toChunk(pt));
                }
            }
        }

        return chunks;
    }

    @Override
    public String getWorld() {
        return config().get(ArenaConfig.WORLD);
    }

    @Override
    public void setWorld(String world) {
        config().set(ArenaConfig.WORLD, world);
    }

    @Override
    public Iterator<BlockVector> iterator() {
        final Vector min = getMinimumPoint();
        final Vector max = getMaximumPoint();

        return new Iterator<BlockVector>() {

            private int nextX = min.getBlockX();
            private int nextY = min.getBlockY();
            private int nextZ = min.getBlockZ();

            public boolean hasNext() {
                return (nextX != Integer.MIN_VALUE);
            }

            public BlockVector next() {
                if (!hasNext()) throw new java.util.NoSuchElementException();
                BlockVector answer = new BlockVector(nextX, nextY, nextZ);
                if (++nextX > max.getBlockX()) {
                    nextX = min.getBlockX();
                    if (++nextY > max.getBlockY()) {
                        nextY = min.getBlockY();
                        if (++nextZ > max.getBlockZ()) {
                            nextX = Integer.MIN_VALUE;
                        }
                    }
                }
                return answer;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        return getName() + ": " + getMinimumPoint() + " - " + getMaximumPoint();
    }
}
