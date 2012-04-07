package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.api.block.Blocks;
import com.dumptruckman.minecraft.matchmaker.api.block.LocalBlock;
import com.dumptruckman.minecraft.matchmaker.api.config.ArenaConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.dumptruckman.minecraft.matchmaker.api.config.MapConfig;
import com.dumptruckman.minecraft.matchmaker.api.config.MapRecord;
import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditAPI;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.regions.Region;

import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;

class DefaultMap /*extends DefaultRegion<MapConfig>*/ implements ArenaMap {
    
    private Config<MapRecord> record;
    private WeakReference<CuboidClipboard> clipboardWeakReference;
    private File schematicFile;
    private String name;

    DefaultMap(File schematicFile, Config<MapRecord> record) {
        this.record = record;
        this.schematicFile = schematicFile;
        this.name = schematicFile.getName().substring(0, schematicFile.getName().indexOf('.'));
        //this.clipboardWeakReference = new WeakReference<CuboidClipboard>(clipboardWeakReference);
        //this.blocks = config.get(MapConfig.BLOCKS);
    }

    DefaultMap(File schematicFile, Config<MapRecord> record, CuboidClipboard clipboard) throws DataException, IOException {
        this(schematicFile, record);
        this.clipboardWeakReference = new WeakReference<CuboidClipboard>(clipboard);
        save();
    }
    
    public String getName() {
        return this.name;
    }

    @Override
    public CuboidClipboard getClipboard() throws DataException, IOException {
        WeakReference<CuboidClipboard> clipRef = this.clipboardWeakReference;
        if (clipRef != null) {
            CuboidClipboard clipboard = this.clipboardWeakReference.get();
            if (clipboard == null) {
                clipboard = CuboidClipboard.loadSchematic(this.schematicFile);
                clipRef = new WeakReference<CuboidClipboard>(clipboard);
            }
        } else {
            clipRef = new WeakReference<CuboidClipboard>(CuboidClipboard.loadSchematic(this.schematicFile));
        }

        return clipRef.get();
    }

    @Override
    public Config<MapRecord> record() {
        return record;
    }

    @Override
    public void save() throws DataException, IOException {
        getClipboard().saveSchematic(schematicFile);
        record().save();
    }
}
