package com.dumptruckman.minecraft.matchmaker.api.block;

import com.dumptruckman.minecraft.matchmaker.api.DataStrings;
import com.dumptruckman.minecraft.pluginbase.util.Logging;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Blocks implements Iterable<LocalBlock> {

    private Set<LocalBlock> blocks;
    
    public Blocks(String blocksString) {
        blocks = new HashSet<LocalBlock>();
        String[] blocksArray = blocksString.split(DataStrings.GENERAL_DELIMITER);
        for (String blockData : blocksArray) {
            LocalBlock lBlock = valueOf(blockData);
            if (lBlock.getLocation() != null) {
                Logging.finer("Parsed block: " + lBlock);
                blocks.add(lBlock);
            }
        }
    }
    
    public Blocks(Set<LocalBlock> blocks) {
        this.blocks = blocks;
    }

    public int size() {
        return blocks.size();
    }
    /**
     * Returns an iterator over a set of elements of type T.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<LocalBlock> iterator() {
        return blocks.iterator();
    }
    
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (LocalBlock block : blocks) {
            if (!buffer.toString().isEmpty()) {
                buffer.append(DataStrings.GENERAL_DELIMITER);
            }
            buffer.append(block.toString());
        }
        return buffer.toString();
    }

    public LocalBlock valueOf(String blockString) {
        return new IBlock(blockString);
    }
}
