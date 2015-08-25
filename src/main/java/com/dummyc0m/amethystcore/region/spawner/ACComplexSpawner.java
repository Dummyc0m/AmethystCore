package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.ChunkRef;
import com.dummyc0m.amethystcore.region.cuboid.ICuboid;
import com.dummyc0m.amethystcore.util.WeightedRandom;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dummyc0m on 8/16/15.
 */
public class ACComplexSpawner extends ACAbstractSpawner {
    private final List<ICuboid> cuboids;
    private final int totalWeight;

    public ACComplexSpawner(String world, List<ICuboid> cuboids, String name, int maxEntityCount, ACEntityData entityData) {
        super(entityData, world, name, maxEntityCount);
        this.cuboids = cuboids;
        totalWeight = WeightedRandom.getWeight(cuboids);
    }

    @Override
    public boolean contains(Location location) {
        for (ICuboid cuboid : cuboids) {
            if (cuboid.contains(location)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChunkRef> getChunks() {
        List<ChunkRef> chunkRefs = new ArrayList<>();
        for (ICuboid cuboid : cuboids) {
            chunkRefs.addAll(cuboid.getChunks());
        }
        return chunkRefs;
    }

    @Override
    public void doSpawn() {
        ICuboid selectedCuboid = (ICuboid) WeightedRandom.getRandomItem(cuboids, totalWeight);
        spawnInCuboid(selectedCuboid);
    }
}
