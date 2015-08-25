package com.dummyc0m.amethystcore.region;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

/**
 * Created by Dummyc0m on 8/26/15.
 */
public final class ChunkRef {
    private final int x;
    private final int z;

    public ChunkRef(Location loc) {
        this.x = getChunkCoords(loc.getBlockX());
        this.z = getChunkCoords(loc.getBlockZ());
    }

    public ChunkRef(int x, int z) {
        this.x = x;
        this.z = z;
    }

    public static int getChunkCoords(final int val) {
        return val >> 4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ChunkRef chunkRef = (ChunkRef) o;

        return new EqualsBuilder()
                .append(x, chunkRef.x)
                .append(z, chunkRef.z)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(x)
                .append(z)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ChunkRef{" +
                "x=" + x +
                ", z=" + z +
                '}';
    }
}
