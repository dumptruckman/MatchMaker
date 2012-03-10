package com.dumptruckman.minecraft.matchmaker;

import com.dumptruckman.minecraft.matchmaker.api.ArenaManager;
import com.dumptruckman.minecraft.matchmaker.api.config.MMConfig;
import com.dumptruckman.minecraft.matchmaker.api.MatchMaker;
import com.dumptruckman.minecraft.matchmaker.command.CreateArenaCommand;
import com.dumptruckman.minecraft.matchmaker.util.Language;
import com.dumptruckman.minecraft.matchmaker.util.YamlPluginConfig;
import com.dumptruckman.minecraft.pluginbase.plugin.AbstractBukkitPlugin;
import com.dumptruckman.minecraft.pluginbase.util.Logging;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MatchMakerPlugin extends AbstractBukkitPlugin<MMConfig> implements MatchMaker<MMConfig> {
    
    private WorldEditPlugin worldEdit = null;
    private ArenaManager arenaManager = null;

    private final List<String> commandPrefixes = Arrays.asList("match", "mm", "mmkr");
    
    File arenaFolder = null;
    
    public void preEnable() {
        arenaFolder = new File(getDataFolder(), "arenas");
        Language.init();
    }

    public void postEnable() {
        worldEdit = (WorldEditPlugin) getServer().getPluginManager().getPlugin("WorldEdit");
        registerCommands();
        try {
            getArenaManager().loadArenas();
        } catch (IOException e) {
            Logging.severe("Could not load arenas!");
            e.printStackTrace();
        }
    }

    private void registerCommands() {
        getCommandHandler().registerCommand(new CreateArenaCommand(this));
    }

    @Override
    public List<String> getCommandPrefixes() {
        return commandPrefixes;
    }

    @Override
    protected MMConfig newConfigInstance() throws IOException {
        return new YamlPluginConfig(this, true, new File(getDataFolder(), "config.yml"), MMConfig.class, YamlPluginConfig.class);
    }
    
    public WorldEditPlugin getWorldEdit() {
        return worldEdit;
    }

    @Override
    public ArenaManager getArenaManager() {
        if (arenaManager == null) {
            arenaManager = new DefaultArenaManager(this);
        }
        return arenaManager;
    }
    
    public File getArenasFolder() {
        return arenaFolder;
    }
}
