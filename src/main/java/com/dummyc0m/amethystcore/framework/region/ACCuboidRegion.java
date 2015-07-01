package com.dummyc0m.amethystcore.framework.region;

import org.bukkit.Location;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public abstract class ACCuboidRegion implements ACRegion {
    private ACCuboid cuboid;

    public ACCuboidRegion(ACCuboid cuboid) {
        this.cuboid = cuboid;
    }

    @Override
    public boolean contains(Location location) {
        return cuboid.contains(location);
    }
}
