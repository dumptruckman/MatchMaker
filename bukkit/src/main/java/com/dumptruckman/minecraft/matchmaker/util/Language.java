package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.pluginbase.locale.Message;

public class Language {

    public static final Message CMD_IN_GAME_ONLY = new Message("cmd.in_game_only",
            "This command may only be used in game!");

    public static final Message CMD_CREATE_ARENA_NAME = new Message("cmd.create_arena.name",
            "Create an arena.");
    public static final Message CMD_CREATE_ARENA_USAGE = new Message("cmd.create_arena.usage",
            "/%1 create arena &6<name>");
    public static final Message CMD_CREATE_ARENA_SUCCESS = new Message("cmd.create_arena.success",
            "You successfully created new arena named: %1");
    public static final Message CMD_CREATE_ARENA_EXISTING_NAME = new Message("cmd.create_arena.existing_name",
            "There is already an arena named: %1");
    public static final Message CMD_CREATE_ARENA_EXISTING_LOCATION = new Message("cmd.create_arena.existing_location",
            "There is already an arena at this location named: %1");
    public static final Message CMD_CREATE_ARENA_FILE_ISSUE = new Message("cmd.create_arena.file_issue",
            "Something went wrong processing the arena files: %1");


    public static final Message CMD_CREATE_MAP_NAME = new Message("cmd.create_map.name",
            "Create a map.");
    public static final Message CMD_CREATE_MAP_USAGE = new Message("cmd.create_map.usage",
            "/%1 save map &6<name>");
    public static final Message CMD_CREATE_MAP_SUCCESS = new Message("cmd.create_map.success",
            "You successfully created new map named: %1");
    public static final Message CMD_CREATE_MAP_EXISTING_NAME = new Message("cmd.create_map.existing_name",
            "There is already an map named: %1");
    public static final Message CMD_CREATE_MAP_FILE_ISSUE = new Message("cmd.create_map.file_issue",
            "Something went wrong processing the map files: %1");

    public static final Message MUST_TARGET_BLOCK = new Message("general.must_target_block",
            "You must be targeting a block!");

    public static final Message MUST_COMPLETE_SELECTION = new Message("worldedit.selection.must_complete",
            "You must complete your selection first!");
    public static final Message CUBOID_SELECTION_ONLY = new Message("worldedit.selection.cuboid_only",
            "Selection must be cuboid!");

    public static final Message CMD_LOAD_MAP_NAME = new Message("cmd.load_map.name",
            "Load a map into targeted arena.");
    public static final Message CMD_LOAD_MAP_USAGE = new Message("cmd.load_map.usage",
            "/%1 load map &6<mapname> [arenaname]");
    public static final Message CMD_LOAD_MAP_NO_MAP = new Message("cmd.load_map.no_map",
            "'%1' is not a valid map name!");
    public static final Message CMD_LOAD_MAP_NO_ARENA = new Message("cmd.load_map.no_arena",
            "You did not specify an existing arena!");
    public static final Message CMD_LOAD_MAP_SUCCESS = new Message("cmd.load_map.success",
            "Map: '%1' loaded into arena: '%2'");

    public static final Message ARENA_LOAD_MAP = new Message("general.arena.load_map",
            "Map: '%1' does not fit into arena: '%2'!");
    public static final Message ARENA_WORLD_UNLOADED = new Message("general.arena.world_unloaded",
            "World: '%1' for arena: '%2' is not loaded!");
    
    public static void init() { }
}
