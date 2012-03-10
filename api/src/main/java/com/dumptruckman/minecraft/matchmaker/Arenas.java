package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.Arena;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.sk89q.worldedit.bukkit.selections.Selection;

import java.util.Iterator;
import java.util.Set;

public class Arenas implements Iterable<Arena> {

    private Set<Arena> arenas;
    
    void add(Arena arena) {
        arenas.add(arena);
    }

    @Override
    public Iterator<Arena> iterator() {
        return new ArenaIterator();
    }

    private class ArenaIterator implements Iterator<Arena> {

        Iterator<Arena> iterator = arenas.iterator();

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Arena next() {
            return iterator.next();
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }
    
    static Arena newArena(String name, Selection selection, Config<ArenaConfig> config, Config<ArenaRecord> record) throws IllegalArgumentException {
        return new DefaultArena(name, selection, config, record);
    }
}
