package com.dummyc0m.amethystcore.framework.region;

import org.bukkit.Location;

/**
 * Created by Dummyc0m on 3/9/15.
 */
public class ACApproximateRegion {
    public final int maxX;
    public final int minX;
    public final int maxY;
    public final int minY;
    public final int maxZ;
    public final int minZ;

    public ACApproximateRegion(int x1, int y1, int z1, int x2, int y2, int z2) {
        this.maxX = Math.max(x1, x2);
        this.minX = Math.min(x1, x2);
        this.maxY = Math.max(y1, y2);
        this.minY = Math.min(y1, y2);
        this.maxZ = Math.max(z1, z2);
        this.minZ = Math.min(z1, z2);
    }

    public ACApproximateRegion(Location loc1, Location loc2) {
        this.maxX = Math.max(loc1.getBlockX(), loc2.getBlockX());
        this.minX = Math.min(loc1.getBlockX(), loc2.getBlockX());
        this.maxY = Math.max(loc1.getBlockY(), loc2.getBlockY());
        this.minY = Math.min(loc1.getBlockY(), loc2.getBlockY());
        this.maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ());
        this.minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ());
    }

    public ACApproximateRegion(ACApproximateRegion region) {
        this.maxX = region.maxX;
        this.minX = region.minX;
        this.maxY = region.maxY;
        this.minY = region.minY;
        this.maxZ = region.maxZ;
        this.minZ = region.minZ;
    }

    public boolean contains(Location location){
        return this.contains(location.getBlockX(), location.getBlockY(), location.getBlockZ());
    }

    public boolean contains(int x, int y, int z){
        return x < this.maxX && x > this.minX && y < this.maxY && y > this.minY && z < this.maxZ && z > this.minZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ACApproximateRegion region3i = (ACApproximateRegion) o;

        if (maxX != region3i.maxX) return false;
        if (maxY != region3i.maxY) return false;
        if (maxZ != region3i.maxZ) return false;
        if (minX != region3i.minX) return false;
        if (minY != region3i.minY) return false;
        if (minZ != region3i.minZ) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = maxX;
        result = 31 * result + minX;
        result = 31 * result + maxY;
        result = 31 * result + minY;
        result = 31 * result + maxZ;
        result = 31 * result + minZ;
        return result;
    }

    @Override
    public String toString() {
        return "AUApproximateRegion{" +
                "maxX=" + maxX +
                ", minX=" + minX +
                ", maxY=" + maxY +
                ", minY=" + minY +
                ", maxZ=" + maxZ +
                ", minZ=" + minZ +
                '}';
    }
}
