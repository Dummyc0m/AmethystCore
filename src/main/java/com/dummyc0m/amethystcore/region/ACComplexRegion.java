package com.dummyc0m.amethystcore.region;

import com.dummyc0m.amethystcore.region.CoreRegion.ChunkRef;
import com.dummyc0m.amethystcore.region.cuboid.IACCuboid;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public class ACComplexRegion extends ACAbstractRegion {
    private final List<IACCuboid> cuboids;

    public ACComplexRegion(List<IACCuboid> cuboids, String name, String displayName) {
        super(name, displayName);
        if (cuboids == null || cuboids.isEmpty()) {
            throw new IllegalArgumentException("Cuboid list is empty");
        }
        this.cuboids = cuboids;
    }

    @Override
    public String getWorld() {
        return cuboids.get(0).getWorld();
    }

    @Override
    public boolean contains(Location location) {
        for (IACCuboid cuboid : cuboids) {
            if (cuboid.contains(location)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChunkRef> getChunks() {
        List<ChunkRef> chunkRefs = new ArrayList<>();
        for (IACCuboid cuboid : cuboids) {
            chunkRefs.addAll(cuboid.getChunks());
        }
        return chunkRefs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACComplexRegion that = (ACComplexRegion) o;

        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(cuboids, that.cuboids)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .appendSuper(super.hashCode())
                .append(cuboids)
                .toHashCode();
    }
}
