package com.dummyc0m.amethystcore.framework.region;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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

        ACApproximateRegion that = (ACApproximateRegion) o;

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
