package com.dummyc0m.amethystcore.framework.region;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

/**
 * Created by Dummyc0m on 3/9/15.
 */
public class ACPreciseRegion {
    public final double maxX;
    public final double minX;
    public final double maxY;
    public final double minY;
    public final double maxZ;
    public final double minZ;

    public ACPreciseRegion(double x1, double y1, double z1, double x2, double y2, double z2) {
        this.maxX = Math.max(x1, x2);
        this.minX = Math.min(x1, x2);
        this.maxY = Math.max(y1, y2);
        this.minY = Math.min(y1, y2);
        this.maxZ = Math.max(z1, z2);
        this.minZ = Math.min(z1, z2);
    }

    public ACPreciseRegion(Location loc1, Location loc2) {
        this.maxX = Math.max(loc1.getX(), loc2.getX());
        this.minX = Math.min(loc1.getX(), loc2.getX());
        this.maxY = Math.max(loc1.getY(), loc2.getY());
        this.minY = Math.min(loc1.getY(), loc2.getY());
        this.maxZ = Math.max(loc1.getZ(), loc2.getZ());
        this.minZ = Math.min(loc1.getZ(), loc2.getZ());
    }

    public ACPreciseRegion(ACPreciseRegion region) {
        this.maxX = region.maxX;
        this.minX = region.minX;
        this.maxY = region.maxY;
        this.minY = region.minY;
        this.maxZ = region.maxZ;
        this.minZ = region.minZ;
    }

    public boolean contains(Location location){
        return this.contains(location.getX(), location.getY(), location.getZ());
    }

    public boolean contains(double x, double y, double z){
        return x < this.maxX && x > this.minX && y < this.maxY && y > this.minY && z < this.maxZ && z > this.minZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACPreciseRegion that = (ACPreciseRegion) o;

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
        return "AUPreciseRegion{" +
                "maxX=" + maxX +
                ", minX=" + minX +
                ", maxY=" + maxY +
                ", minY=" + minY +
                ", maxZ=" + maxZ +
                ", minZ=" + minZ +
                '}';
    }
}
