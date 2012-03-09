package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.pluginbase.config.AdvancedConfigEntry;
import com.dumptruckman.minecraft.pluginbase.util.Logging;
import com.sk89q.worldedit.Vector;

public class VectorEntry extends AdvancedConfigEntry<Vector> {

    public VectorEntry(String path, Vector def, String... comments) {
        super(Vector.class, path, def, comments);
    }

    @Override
    public Object serialize(Vector vector) {
        return vector.getBlockX() + "," + vector.getBlockY() + "," + vector.getBlockZ();
    }

    @Override
    public Vector deserialize(Object o) {
        String[] coords = o.toString().split(",");
        try {
            return new Vector(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]), Integer.valueOf(coords[2]));
        } catch (Exception e) {
            Logging.warning("Could not parse vector from string: " + o.toString());
            e.printStackTrace();
            return null;
        }
    }
}
