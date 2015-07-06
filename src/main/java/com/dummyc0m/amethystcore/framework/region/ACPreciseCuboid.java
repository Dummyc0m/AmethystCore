package com.dummyc0m.amethystcore.framework.region;

import com.dummyc0m.amethystcore.framework.region.ACRegionManager.ChunkRef;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dummyc0m on 3/9/15.
 */
public abstract class ACPreciseCuboid implements ACCuboid {
    public final double maxX;
    public final double minX;
    public final double maxY;
    public final double minY;
    public final double maxZ;
    public final double minZ;

    public ACPreciseCuboid(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.maxX = Math.max(x1, x2);
        this.minX = Math.min(x1, x2);
        this.maxY = Math.max(y1, y2);
        this.minY = Math.min(y1, y2);
        this.maxZ = Math.max(z1, z2);
        this.minZ = Math.min(z1, z2);
    }

    public ACPreciseCuboid(Location loc1, Location loc2) {
        this.maxX = Math.max(loc1.getX(), loc2.getX());
        this.minX = Math.min(loc1.getX(), loc2.getX());
        this.maxY = Math.max(loc1.getY(), loc2.getY());
        this.minY = Math.min(loc1.getY(), loc2.getY());
        this.maxZ = Math.max(loc1.getZ(), loc2.getZ());
        this.minZ = Math.min(loc1.getZ(), loc2.getZ());
    }

    public ACPreciseCuboid(ACPreciseCuboid region) {
        this.maxX = region.maxX;
        this.minX = region.minX;
        this.maxY = region.maxY;
        this.minY = region.minY;
        this.maxZ = region.maxZ;
        this.minZ = region.minZ;
    }

    @Override
    public boolean contains(Location location){
        return this.contains(location.getX(), location.getY(), location.getZ());
    }

    public boolean contains(double x, double y, double z){
        return x < this.maxX && x > this.minX && y < this.maxY && y > this.minY && z < this.maxZ && z > this.minZ;
    }

    @Override
    public List<ChunkRef> getChunks() {
        List<ChunkRef> chunkRefs = new ArrayList<>();
        int minX = ChunkRef.getChunkCoords((int) (this.minX + 0.5));
        int minZ = ChunkRef.getChunkCoords((int) (this.minZ + 0.5));
        int maxX = ChunkRef.getChunkCoords((int) (this.maxX + 0.5));
        int maxZ = ChunkRef.getChunkCoords((int) (this.maxZ + 0.5));
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                chunkRefs.add(new ChunkRef(x, z));
            }
        }
        return chunkRefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACPreciseCuboid that = (ACPreciseCuboid) o;

        return new EqualsBuilder()
                .append(maxX, that.maxX)
                .append(minX, that.minX)
                .append(maxY, that.maxY)
                .append(minY, that.minY)
                .append(maxZ, that.maxZ)
                .append(minZ, that.minZ)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(maxX)
                .append(minX)
                .append(maxY)
                .append(minY)
                .append(maxZ)
                .append(minZ)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "AUPreciseCuboid{" +
                "maxX=" + maxX +
                ", minX=" + minX +
                ", maxY=" + maxY +
                ", minY=" + minY +
                ", maxZ=" + maxZ +
                ", minZ=" + minZ +
                '}';
    }
}
