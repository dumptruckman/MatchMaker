package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.MapManager;
import com.dumptruckman.minecraft.matchmaker.api.block.Blocks;
import com.dumptruckman.minecraft.matchmaker.api.block.BukkitBlocks;
import com.dumptruckman.minecraft.matchmaker.api.block.LocalBlock;
import com.dumptruckman.minecraft.matchmaker.api.config.MapConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MapRecord;
import com.dumptruckman.minecraft.matchmaker.util.Language;
import com.dumptruckman.minecraft.matchmaker.util.YamlConfig;
import com.dumptruckman.minecraft.pluginbase.locale.Messager;
import com.dumptruckman.minecraft.pluginbase.util.Logging;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;

import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

class DefaultMapManager implements MapManager {

    private Maps maps = new Maps();
    MatchMakerPlugin matchMaker;
    
    DefaultMapManager(MatchMakerPlugin matchMaker) {
        this.matchMaker = matchMaker;
    }

    @Override
    public ArenaMap getMap(String name) {
        ArenaMap arenaMap = null;
        for (ArenaMap map : getMaps()) {
            if (map.getName().equalsIgnoreCase(name)) {
                arenaMap = map;
                break;
            }
        }
        if (arenaMap == null) {
            arenaMap = loadMap(name);
        }
        return arenaMap;
    }

    public Maps getMaps() {
        return maps;
    }

    public ArenaMap newMap(String name, CuboidClipboard clipboard) throws IllegalArgumentException, IOException, DataException {
        Messager messager = matchMaker.getMessager();
        if (getMap(name) != null) {
            throw new IllegalArgumentException(messager.getMessage(Language.CMD_CREATE_MAP_EXISTING_NAME, name));
        }
        
        File mapRecords = new File(matchMaker.getMapFolder(), "records");
        ArenaMap map = Maps.newMap(new File(matchMaker.getMapFolder(), name + ".schematic"),
                new YamlConfig<MapRecord>(matchMaker, false, new File(
                        mapRecords, name + ".yml"), MapRecord.class), clipboard);
        maps.add(map);
        return map;
    }

    private ArenaMap loadMap(String name) {
        File mapFolder = matchMaker.getMapFolder();
        if (!mapFolder.exists()) {
            return null;
        }
        File mapFile = new File(mapFolder, name + ".schematic");
        if (!mapFile.exists())  {
            return null;
        }
        File recordFile = new File(new File(mapFolder, "records"), name + ".yml");
        try {
            ArenaMap map = Maps.newMap(mapFile,
                    new YamlConfig<MapRecord>(matchMaker, false, recordFile, MapRecord.class));
            maps.add(map);
            return map;
        } catch (IOException e) {
            Logging.severe("Error loading map!");
            e.printStackTrace();
        }
        return null;
    }
}
