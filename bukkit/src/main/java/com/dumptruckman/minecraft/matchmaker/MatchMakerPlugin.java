package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.config.Config;
import com.dumptruckman.minecraft.matchmaker.api.MatchMaker;
import com.dumptruckman.minecraft.matchmaker.util.Language;
import com.dumptruckman.minecraft.matchmaker.util.YamlConfig;
import com.dumptruckman.minecraft.pluginbase.plugin.AbstractBukkitPlugin;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MatchMakerPlugin extends AbstractBukkitPlugin<Config> implements MatchMaker<Config> {

    private final List<String> commandPrefixes = Arrays.asList("match", "mm", "mmkr");
    
    public void preEnable() {
        Language.init();
    }

    public void postEnable() {
        registerCommands();
    }

    private void registerCommands() {
    }

    @Override
    public List<String> getCommandPrefixes() {
        return commandPrefixes;
    }

    @Override
    protected Config newConfigInstance() throws IOException {
        return new YamlConfig(this, true, new File(getDataFolder(), "config.yml"), Config.class, YamlConfig.class);
    }
}
