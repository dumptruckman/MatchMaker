package com.dumptruckman.minecraft.matchmaker.command;

import com.dumptruckman.minecraft.matchmaker.MatchMakerPlugin;
import com.dumptruckman.minecraft.matchmaker.api.Arena;
import com.dumptruckman.minecraft.matchmaker.api.ArenaMap;
import com.dumptruckman.minecraft.matchmaker.util.Language;
import com.dumptruckman.minecraft.matchmaker.util.Perms;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldedit.regions.Region;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.List;

public class CreateMapCommand extends MMCommand {

    public CreateMapCommand(MatchMakerPlugin plugin) {
        super(plugin);
        this.setName(messager.getMessage(Language.CMD_CREATE_MAP_NAME));
        this.setCommandUsage(messager.getMessage(Language.CMD_CREATE_MAP_USAGE, plugin.getCommandPrefixes().get(0)));
        this.setArgRange(1, 1);
        for (String prefix : plugin.getCommandPrefixes()) {
            this.addKey(prefix + " create map");
            this.addKey(prefix + " save map");
        }
        this.addCommandExample("/" + plugin.getCommandPrefixes().get(0) + " save map " + ChatColor.GOLD + "Map1");
        this.setPermission(Perms.CMD_CREATE_MAP.getPermission());
    }

    @Override
    public void runCommand(CommandSender sender, List<String> args) {
        if (!(sender instanceof Player)) {
            messager.bad(Language.CMD_IN_GAME_ONLY, sender);
            return;
        }
        Player player = (Player) sender;
        Selection selection = plugin.getWorldEdit().getSelection(player);
        if (!(selection instanceof CuboidSelection)) {
            messager.normal(Language.CUBOID_SELECTION_ONLY, sender);
            return;
        }
        Region region;
        try {
            region = selection.getRegionSelector().getRegion();
        } catch (IncompleteRegionException e) {
            messager.normal(Language.MUST_COMPLETE_SELECTION, sender);
            return;
        }
        ArenaMap map;
        try {
            map = plugin.getMapManager().newMap(args.get(0), region);
        } catch (IllegalArgumentException e) {
            messager.sendMessage(sender, e.getMessage());
            return;
        } catch (IOException e) {
            messager.bad(Language.CMD_CREATE_MAP_FILE_ISSUE, sender, e.getMessage());
            return;
        }
        messager.good(Language.CMD_CREATE_MAP_SUCCESS, sender, map.getName());
    }
}
