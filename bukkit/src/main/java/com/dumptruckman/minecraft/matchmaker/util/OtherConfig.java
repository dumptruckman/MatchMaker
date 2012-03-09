package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.pluginbase.config.AbstractYamlConfig;
import com.dumptruckman.minecraft.pluginbase.config.Config;
import com.dumptruckman.minecraft.pluginbase.config.ConfigEntry;
import com.dumptruckman.minecraft.pluginbase.plugin.BukkitPlugin;

import java.io.File;
import java.io.IOException;

public class OtherConfig<V extends Config> extends AbstractYamlConfig<V> implements Config<V> {

    public OtherConfig(BukkitPlugin plugin, boolean doComments, File configFile, Class<? extends V>... configClasses) throws IOException {
        super(plugin, doComments, configFile, configClasses);
    }

    @Override
    protected ConfigEntry getSettingsEntry() {
        return null;
    }

    protected String getHeader() {
        return "";
    }
}
