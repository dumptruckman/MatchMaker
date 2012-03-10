package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.pluginbase.locale.Message;

public class Language {

    public static final Message CMD_CREATE_ARENA_NAME = new Message("cmd.create_arena.name",
            "Create an Arena.");
    public static final Message CMD_CREATE_ARENA_USAGE = new Message("cmd.create_arena.usage",
            "/%1 create arena &6<name>");
    public static final Message CMD_CREATE_ARENA_SUCCESS = new Message("cmd.create_arena.success",
            "You successfully created new arena named: %1");
    public static final Message CMD_CREATE_ARENA_EXISTING_NAME = new Message("cmd.create_arena.existing_name",
            "There is already an arena named: %1");
    public static final Message CMD_CREATE_ARENA_CUBOID_ONLY = new Message("cmd.create_arena.cuboid_only",
            "Selection must be cuboid!");
    public static final Message CMD_CREATE_ARENA_EXISTING_LOCATION = new Message("cmd.create_arena.existing_location",
            "There is already an arena at this location named: %1");
    public static final Message CMD_CREATE_ARENA_FILE_ISSUE = new Message("cmd.create_arena.file_issue",
            "Something went wrong processing the arena files: %1");
    public static final Message CMD_CREATE_ARENA_INCOMPLETE = new Message("cmd.create_arena.incomplete",
            "You must complete your selection first!");

    public static final Message CMD_IN_GAME_ONLY = new Message("cmd.in_game_only",
            "This command may only be used in game!");
    
    public static void init() { }
}
