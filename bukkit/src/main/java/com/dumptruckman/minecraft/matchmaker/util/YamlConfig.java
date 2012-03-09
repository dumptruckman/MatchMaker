package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.dumptruckman.minecraft.pluginbase.config.AbstractYamlConfig;
import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.config.IConfig;
import com.dumptruckman.minecraft.pluginbase.config.Null;
import com.dumptruckman.minecraft.pluginbase.config.SimpleConfigEntry;
import com.dumptruckman.minecraft.pluginbase.plugin.BukkitPlugin;

import java.io.File;
import java.io.IOException;

/**
 * Commented Yaml implementation of Config.
 */
public class YamlConfig extends AbstractYamlConfig implements Config {

    private static final ConfigEntry<Null> SETTINGS = new SimpleConfigEntry<Null>(Null.class, "settings", null, "# === [ MatchMaker Settings ] ===");

    public YamlConfig(BukkitPlugin plugin, boolean doComments, File configFile, Class<? extends IConfig>... configClasses) throws IOException {
        super(plugin, doComments, configFile, configClasses);
    }

    @Override
    protected ConfigEntry getSettingsEntry() {
        return SETTINGS;
    }
    
    protected String getHeader() {
        return "# === [ MatchMaker Config ] ===";
    }
}
