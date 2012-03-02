package com.dumptruckman.minecraft.matchmaker.api;

import com.dumptruckman.minecraft.config.BaseConfig;
import com.dumptruckman.minecraft.plugin.BukkitPlugin;
import org.bukkit.plugin.Plugin;

public interface MatchMaker<C extends BaseConfig> extends BukkitPlugin<C>, Plugin {

}
