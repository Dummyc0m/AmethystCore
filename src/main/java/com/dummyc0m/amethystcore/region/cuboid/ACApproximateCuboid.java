package com.dummyc0m.amethystcore.region.cuboid;

import com.dummyc0m.amethystcore.region.CoreRegion.ChunkRef;
import com.dummyc0m.amethystcore.util.MathUtil;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dummyc0m on 3/9/15.
 */
public class ACApproximateCuboid implements IACCuboid {
    private final int maxX;
    private final int minX;
    private final int maxY;
    private final int minY;
    private final int maxZ;
    private final int minZ;
    private final String world;
    private final int blockVolume;
    private final double preciseVolume;

    public ACApproximateCuboid(String world, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.world = world;
        this.maxX = Math.max(x1, x2);
        this.minX = Math.min(x1, x2);
        this.maxY = Math.max(y1, y2);
        this.minY = Math.min(y1, y2);
        this.maxZ = Math.max(z1, z2);
        this.minZ = Math.min(z1, z2);
        this.blockVolume = (maxX - minX) * (maxY - minY) * (maxZ - minZ);
        this.preciseVolume = blockVolume;
    }

    public ACApproximateCuboid(Location loc1, Location loc2) {
        if (!loc1.getWorld().equals(loc2.getWorld())) {
            throw new IllegalArgumentException("Locations in different worlds");
        }
        this.world = loc1.getWorld().getName();
        this.maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        this.minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        this.maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        this.minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        this.maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
        this.minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
        this.blockVolume = (maxX - minX) * (maxY - minY) * (maxZ - minZ);
        this.preciseVolume = blockVolume;
    }

    @Override
    public boolean contains(Location location) {
        return this.contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public boolean contains(int x, int y, int z) {
        return x < this.maxX && x > this.minX && y < this.maxY && y > this.minY && z < this.maxZ && z > this.minZ;
    }

    @Override
    public List<ChunkRef> getChunks() {
        List<ChunkRef> chunkRefs = new ArrayList<>();
        int minX = ChunkRef.getChunkCoords(this.minX);
        int minZ = ChunkRef.getChunkCoords(this.minZ);
        int maxX = ChunkRef.getChunkCoords(this.maxX);
        int maxZ = ChunkRef.getChunkCoords(this.maxZ);
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                chunkRefs.add(new ChunkRef(x, z));
            }
        }
        return chunkRefs;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMinX() {
        return minX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getMinY() {
        return minY;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public int getMinZ() {
        return minZ;
    }

    @Override
    public String getWorld() {
        return world;
    }

    @Override
    public Location getRandomPoint() {
        return new Location(Bukkit.getWorld(world), MathUtil.random(minX, maxX), MathUtil.random(minY, maxY), MathUtil.random(minZ, maxZ));
    }

    @Override
    public int getBlockVolume() {
        return blockVolume;
    }

    @Override
    public double getPreciseVolume() {
        return preciseVolume;
    }

    @Override
    public int getWeight() {
        return blockVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACApproximateCuboid that = (ACApproximateCuboid) o;

        return new EqualsBuilder()
                .append(maxX, that.maxX)
                .append(minX, that.minX)
                .append(maxY, that.maxY)
                .append(minY, that.minY)
                .append(maxZ, that.maxZ)
                .append(minZ, that.minZ)
                .append(blockVolume, that.blockVolume)
                .append(preciseVolume, that.preciseVolume)
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
                .append(blockVolume)
                .append(preciseVolume)
                .toHashCode();
    }
}
