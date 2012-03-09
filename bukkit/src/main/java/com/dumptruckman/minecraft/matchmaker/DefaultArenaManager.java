package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.Arena;
import com.dumptruckman.minecraft.matchmaker.api.ArenaManager;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaRecord;
import com.dumptruckman.minecraft.matchmaker.util.Language;
import com.dumptruckman.minecraft.matchmaker.util.OtherConfig;
import com.dumptruckman.minecraft.pluginbase.config.Config;
import com.dumptruckman.minecraft.pluginbase.locale.Messager;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;

import java.io.File;
import java.io.IOException;

class DefaultArenaManager implements ArenaManager {

    private Arenas arenas = new Arenas();
    private MatchMakerPlugin matchMaker;
    
    public DefaultArenaManager(MatchMakerPlugin matchMaker) {
        this.matchMaker = matchMaker;
    }

    @Override
    public Arena getArena(String name) {
        for (Arena arena : getArenas()) {
            if (arena.getName().equalsIgnoreCase(name)) {
                return arena;
            }
        }
        return null;
    }

    public Arenas getArenas() {
        return arenas;
    }

    public Arena getIntersectingArena(Selection selection) {
        for (Arena arena : getArenas()) {
            if (!arena.getWorld().equals(selection.getWorld())) {
                continue;
            }
            if (selection.getNativeMaximumPoint().containedWithin(arena.getMinimumPoint(), arena.getMaximumPoint())
                || selection.getNativeMinimumPoint().containedWithin(arena.getMinimumPoint(), arena.getMaximumPoint())) {
                return arena;
            }
        }
        return null;
    }

    public Arena newArena(String name, Selection selection) throws IllegalArgumentException, IOException {
        Messager messager = matchMaker.getMessager();
        if (getArena(name) != null) {
            throw new IllegalArgumentException(messager.getMessage(Language.CMD_CREATE_ARENA_EXISTING_NAME, name));
        }
        if (!(selection instanceof CuboidSelection)) {
            throw new IllegalArgumentException(messager.getMessage(Language.CMD_CREATE_ARENA_CUBOID_ONLY));
        }
        Arena existingArena = matchMaker.getArenaManager().getIntersectingArena(selection);
        if (existingArena != null) {
            throw new IllegalArgumentException(messager.getMessage(Language.CMD_CREATE_ARENA_EXISTING_LOCATION, existingArena.getName()));
        }
        Arena arena = Arenas.newArena(name, selection,
                new OtherConfig<ArenaConfig>(matchMaker, false, new File(
                        matchMaker.getArenasFolder(), name + "-config.yml"), ArenaConfig.class),
                new OtherConfig<ArenaRecord>(matchMaker, false, new File(
                        matchMaker.getArenasFolder(), name + "-record.yml"), ArenaRecord.class));
        arenas.add(arena);
        return arena;
    }
}
