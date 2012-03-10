package com.dumptruckman.minecraft.matchmaker.api.config;

import com.dumptruckman.minecraft.matchmaker.api.block.Blocks;
import com.dumptruckman.minecraft.matchmaker.api.block.LocalBlock;
import com.dumptruckman.minecraft.pluginbase.config.AdvancedConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;
import com.dumptruckman.minecraft.pluginbase.util.Logging;

import java.util.HashSet;

/**
 * Contains the configuration for a single Map.
 */
public interface MapConfig extends RegionConfig<MapConfig> {

    ConfigEntry<String> NAME = new SimpleConfigEntry<String>(String.class, "name", "");

    ConfigEntry<Blocks> BLOCKS = new AdvancedConfigEntry<Blocks>(Blocks.class, "blocks", new Blocks(new HashSet<LocalBlock>())) {
        @Override
        public Object serialize(Blocks blocks) {
            return blocks.toString();
        }

        @Override
        public Blocks deserialize(Object o) {
            System.out.println("Deserializing blocks: " + o.toString());
            return new Blocks(o.toString());
        }
    };
}
