package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.pluginbase.permission.Perm;

public class Perms {

    // A example permission, forms the perm "matchmaker.example"
    public static final Perm CMD_CREATE_ARENA = new Perm.Builder("create.arena").desc("Gives user access to 'create arena' command.").build();
    
    private Perms() {
        throw new AssertionError();
    }
}
