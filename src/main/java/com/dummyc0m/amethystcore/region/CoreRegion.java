package com.dummyc0m.amethystcore.region;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dummyc0m on 6/4/15.
 */
public class CoreRegion {
    private final Map<String, IACRegion> nameRegionMap = new HashMap<>();
    private final Map<String, Map<ChunkRef, List<IACRegion>>> worldChunkRegionMap = new HashMap<>();

    public void addRegion(IACRegion region) {
        String world = region.getWorld();
        Map<ChunkRef, List<IACRegion>> chunkRegionMap = worldChunkRegionMap.get(world);
        if (chunkRegionMap == null) {
            chunkRegionMap = new HashMap<>();
            worldChunkRegionMap.put(world, chunkRegionMap);
        }
        for (ChunkRef chunkRef : region.getChunks()) {
            List<IACRegion> regions = chunkRegionMap.get(chunkRef);
            if (regions == null) {
                regions = new ArrayList<>();
                chunkRegionMap.put(chunkRef, regions);
            }
            regions.add(region);
        }
        nameRegionMap.put(region.getName(), region);
    }

    public IACRegion getRegion(Location location) {
        String world = location.getWorld().getName();
        ChunkRef chunkRef = new ChunkRef(location);
        if (!worldChunkRegionMap.containsKey(world) || !worldChunkRegionMap.get(world).containsKey(chunkRef)) {
            return null;
        }
        for (IACRegion region : worldChunkRegionMap.get(world).get(chunkRef)) {
            if (region.contains(location)) {
                return region;
            }
        }
        return null;
    }

    public IACRegion getRegion(String name) {
        return nameRegionMap.get(name);
    }


    public static final class ChunkRef {
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
}