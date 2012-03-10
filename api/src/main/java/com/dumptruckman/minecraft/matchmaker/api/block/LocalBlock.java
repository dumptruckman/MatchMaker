package com.dumptruckman.minecraft.matchmaker.api.block;

import com.sk89q.worldedit.BlockVector;

public interface LocalBlock {

    public int getTypeId();

    public byte getBlockData();
    
    BlockVector getLocation();

    public int getX();

    public int getY();

    public int getZ();
}
