package com.dummyc0m.amethystcore.region;

import com.dummyc0m.amethystcore.region.ACRegionManager.ChunkRef;
import com.dummyc0m.amethystcore.region.cuboid.IACCuboid;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public class ACCuboidRegion extends ACAbstractRegion {
    private final IACCuboid cuboid;

    public ACCuboidRegion(IACCuboid cuboid, String name, String displayName) {
        super(name, displayName);
        if (cuboid == null) {
            throw new IllegalArgumentException("Cuboid cannot be null");
        }
        this.cuboid = cuboid;
    }

    @Override
    public String getWorld() {
        return cuboid.getWorld();
    }

    @Override
    public boolean contains(Location location) {
        return cuboid.contains(location);
    }

    @Override
    public List<ChunkRef> getChunks() {
        return cuboid.getChunks();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACCuboidRegion that = (ACCuboidRegion) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(cuboid, that.cuboid)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(cuboid)
                .toHashCode();
    }
}
