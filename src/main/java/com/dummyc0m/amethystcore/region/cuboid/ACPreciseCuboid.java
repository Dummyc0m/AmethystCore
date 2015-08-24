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
public class ACPreciseCuboid implements ICuboid {
    private final double maxX;
    private final double minX;
    private final double maxY;
    private final double minY;
    private final double maxZ;
    private final double minZ;
    private final String world;
    private final int blockVolume;
    private final double preciseVolume;

    public ACPreciseCuboid(String world, double x1, double y1, double z1, double x2, double y2, double z2) {
        this.world = world;
        this.maxX = Math.max(x1, x2);
        this.minX = Math.min(x1, x2);
        this.maxY = Math.max(y1, y2);
        this.minY = Math.min(y1, y2);
        this.maxZ = Math.max(z1, z2);
        this.minZ = Math.min(z1, z2);
        this.preciseVolume = (maxX - minX) * (maxY - minY) * (maxZ - minZ);
        this.blockVolume = (int) preciseVolume;
    }

    public ACPreciseCuboid(Location loc1, Location loc2) {
        if (!loc1.getWorld().equals(loc2.getWorld())) {
            throw new IllegalArgumentException("Locations in different worlds");
        }
        this.world = loc1.getWorld().getName();
        this.maxX = Math.max(loc1.getX(), loc2.getX());
        this.minX = Math.min(loc1.getX(), loc2.getX());
        this.maxY = Math.max(loc1.getY(), loc2.getY());
        this.minY = Math.min(loc1.getY(), loc2.getY());
        this.maxZ = Math.max(loc1.getZ(), loc2.getZ());
        this.minZ = Math.min(loc1.getZ(), loc2.getZ());
        this.preciseVolume = (maxX - minX) * (maxY - minY) * (maxZ - minZ);
        this.blockVolume = (int) preciseVolume;
    }

    @Override
    public boolean contains(Location location) {
        return this.contains(location.getX(), location.getY(), location.getZ());
    }

    public boolean contains(double x, double y, double z) {
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

    public double getMaxX() {
        return maxX;
    }

    public double getMinX() {
        return minX;
    }

    public double getMaxY() {
        return maxY;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxZ() {
        return maxZ;
    }

    public double getMinZ() {
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

        ACPreciseCuboid that = (ACPreciseCuboid) o;

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
