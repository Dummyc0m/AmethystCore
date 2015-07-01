package com.dummyc0m.amethystcore.framework.region;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dummyc0m on 6/4/15.
 */
public class ACRegionManager {
    private static final ACRegionManager instance = new ACRegionManager();
    private Map<String, ACRegion> stringRegionMap = new HashMap<>();
    private Map<World, Map<ChunkRef, List<ACRegion>>> chunkRegionMap = new HashMap<>();

    public static ACRegionManager getInstance() {
        return instance;
    }

    public void addRegion(ACRegion region) {

    }


    public static final class ChunkRef {
        private final int x;
        private final int z;

        public ChunkRef(Location loc) {
            this.x = getChunkRef(loc.getBlockX());
            this.z = getChunkRef(loc.getBlockZ());
        }

        public ChunkRef(int x, int z) {
            this.x = x;
            this.z = z;
        }

        public static int getChunkRef(final int val) {
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
}