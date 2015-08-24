package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.CoreRegion;
import com.dummyc0m.amethystcore.region.cuboid.IACCuboid;
import com.dummyc0m.amethystcore.util.WeightedRandom;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dummyc0m on 8/16/15.
 */
public class ACComplexSpawner extends ACAbstractSpawner {
    private final List<IACCuboid> cuboids;
    private final int totalWeight;

    public ACComplexSpawner(String world, List<IACCuboid> cuboids, String name, int maxEntityCount, ACEntityData entityData) {
        super(entityData, world, name, maxEntityCount);
        this.cuboids = cuboids;
        totalWeight = WeightedRandom.getWeight(cuboids);
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
    public List<CoreRegion.ChunkRef> getChunks() {
        List<CoreRegion.ChunkRef> chunkRefs = new ArrayList<>();
        for (IACCuboid cuboid : cuboids) {
            chunkRefs.addAll(cuboid.getChunks());
        }
        return chunkRefs;
    }

    @Override
    public void doSpawn() {
        IACCuboid selectedCuboid = (IACCuboid) WeightedRandom.getRandomItem(cuboids, totalWeight);
        spawnInCuboid(selectedCuboid);
    }
}
