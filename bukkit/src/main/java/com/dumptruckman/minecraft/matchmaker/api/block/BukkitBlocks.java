package com.dumptruckman.minecraft.matchmaker.api.block;

import com.sk89q.worldedit.BlockVector;
import org.bukkit.block.Block;

public class BukkitBlocks {
    
    public static LocalBlock valueOf(Block block, int x, int y, int z) {
        return new IBlock(block.getTypeId(), block.getData(), new BlockVector(x, y, z));
    }
}
