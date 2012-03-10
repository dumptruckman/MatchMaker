package com.dumptruckman.minecraft.matchmaker.api.block;

import com.dumptruckman.minecraft.matchmaker.api.DataStrings;
import com.sk89q.worldedit.BlockVector;

class IBlock implements LocalBlock {

    private int typeId = 0;
    private byte data = 0;
    private BlockVector location = null;

    IBlock(int typeId, byte data, BlockVector loc) {
        this.typeId = typeId;
        this.data = data;
        this.location = loc;
    }

    IBlock(int typeId, byte data, int x, int y, int z) {
        this.typeId = typeId;
        this.data = data;
        this.location = new BlockVector(x, y, z);
    }

    IBlock(String blockString) {
        Integer x = null;
        Integer y = null;
        Integer z = null;

        String[] blockData = blockString.split(DataStrings.SECONDARY_DELIMITER);
        for (String blockElement : blockData) {
            String[] elementEntry = DataStrings.splitEntry(blockElement);
            if (elementEntry[0].equals(DataStrings.BLOCK_DATA)) {
                try {
                    data = Byte.valueOf(elementEntry[1]);
                } catch (NumberFormatException ignore) { }
            } else if (elementEntry[0].equals(DataStrings.BLOCK_TYPE)) {
                try {
                    typeId = Integer.valueOf(elementEntry[1]);
                } catch (NumberFormatException ignore) { }
            } else if (elementEntry[0].equals(DataStrings.BLOCK_X)) {
                try {
                    x = Integer.valueOf(elementEntry[1]);
                } catch (NumberFormatException ignore) { }
            } else if (elementEntry[0].equals(DataStrings.BLOCK_Y)) {
                try {
                    y = Integer.valueOf(elementEntry[1]);
                } catch (NumberFormatException ignore) { }
            } else if (elementEntry[0].equals(DataStrings.BLOCK_Z)) {
                try {
                    z = Integer.valueOf(elementEntry[1]);
                } catch (NumberFormatException ignore) { }
            }
        }
        if (x != null && y != null && z != null) {
            location = new BlockVector(x, y, z);
        }
    }

    public BlockVector getLocation() {
        return this.location;
    }

    public int getTypeId() {
        return this.typeId;
    }

    public byte getBlockData() {
        return this.data;
    }

    public int getX() {
        return this.getLocation().getBlockX();
    }

    public int getY() {
        return this.getLocation().getBlockY();
    }

    public int getZ() {
        return this.getLocation().getBlockZ();
    }

    public String toString() {
        String result = DataStrings.createEntry(DataStrings.BLOCK_X, location.getBlockX())
                + DataStrings.SECONDARY_DELIMITER + DataStrings.createEntry(DataStrings.BLOCK_Y, location.getBlockY())
                + DataStrings.SECONDARY_DELIMITER + DataStrings.createEntry(DataStrings.BLOCK_Z, location.getBlockZ())
                + DataStrings.SECONDARY_DELIMITER + DataStrings.createEntry(DataStrings.BLOCK_TYPE, typeId)
                + DataStrings.SECONDARY_DELIMITER + DataStrings.createEntry(DataStrings.BLOCK_DATA, data);
        return result;
    }
}
