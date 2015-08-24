package com.dummyc0m.amethystcore.region.cuboid;

import com.dummyc0m.amethystcore.region.ACRegionManager.ChunkRef;
import com.dummyc0m.amethystcore.util.WeightedRandom;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Dummyc0m on 6/6/15.
 */
public interface IACCuboid extends WeightedRandom.IWeightedItem {
    boolean contains(Location location);

    List<ChunkRef> getChunks();

    String getWorld();

    int getBlockVolume();

    double getPreciseVolume();

    Location getRandomPoint();
}
