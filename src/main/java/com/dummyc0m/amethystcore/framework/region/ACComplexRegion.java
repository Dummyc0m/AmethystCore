package com.dummyc0m.amethystcore.framework.region;

import org.bukkit.Location;

import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public abstract class ACComplexRegion implements ACRegion {
    private List<ACCuboid> cuboids;

    public ACComplexRegion(List<ACCuboid> cuboids) {
        this.cuboids = cuboids;
    }

    @Override
    public boolean contains(Location location) {
        for (ACCuboid cuboid : cuboids) {
            if (cuboid.contains(location)) {
                return true;
            }
        }
        return false;
    }
}
