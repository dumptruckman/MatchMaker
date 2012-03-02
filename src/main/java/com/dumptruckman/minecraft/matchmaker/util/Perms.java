package com.dumptruckman.minecraft.matchmaker.util;

import com.dumptruckman.minecraft.permission.Perm;

public class Perms {

    // A example permission, forms the perm "matchmaker.example"
    public static final Perm EXAMPLE = new Perm.Builder("example").desc("Gives user access to all MatchMaker permissions").build();
    
    private Perms() {
        throw new AssertionError();
    }
}
