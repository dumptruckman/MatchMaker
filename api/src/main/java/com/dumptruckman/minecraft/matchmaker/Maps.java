package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.block.Blocks;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.dumptruckman.minecraft.matchmaker.api.config.MapConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MapRecord;
import com.sk89q.worldedit.regions.Region;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Maps implements Iterable<ArenaMap> {

    private Set<ArenaMap> maps = new HashSet<ArenaMap>();

    void add(ArenaMap map) {
        maps.add(map);
    }

    void clear() {
        maps.clear();
    }

    int size() {
        return maps.size();
    }

    @Override
    public Iterator<ArenaMap> iterator() {
        return new MapIterator();
    }

    private class MapIterator implements Iterator<ArenaMap> {

        Iterator<ArenaMap> iterator = maps.iterator();;
        /*
        ArenaIterator(Set<Arena> arenas) {
            iterator =
        }
        */
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public ArenaMap next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }

    static ArenaMap newMap(String name, Region region, Blocks blocks, Config<MapConfig> config, Config<MapRecord> record) throws IllegalArgumentException {
        return new DefaultMap(name, region, blocks, config, record);
    }

    static ArenaMap newMap(Config<MapConfig> config, Config<MapRecord> record) {
        return new DefaultMap(config, record);
    }
}
