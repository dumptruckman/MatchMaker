package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.pluginbase.permission.Perm;

public class Perms {

    public static final Perm CMD_CREATE_ARENA = new Perm.Builder("arena.create").desc("Gives user access to 'create arena' command.").build();

    public static final Perm CMD_CREATE_MAP = new Perm.Builder("map.create").desc("Gives user access to 'create map' command.").build();

    public static final Perm CMD_LOAD_MAP = new Perm.Builder("map.load").desc("Gives user access to 'create map' command.").build();
    
    private Perms() {
        throw new AssertionError();
    }
}
