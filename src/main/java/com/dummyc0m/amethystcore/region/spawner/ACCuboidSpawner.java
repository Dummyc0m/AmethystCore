package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.ACRegionManager;
import com.dummyc0m.amethystcore.region.cuboid.IACCuboid;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Dummyc0m on 8/16/15.
 */
public class ACCuboidSpawner extends ACAbstractSpawner {
    private final IACCuboid cuboid;

    public ACCuboidSpawner(String world, IACCuboid cuboid, String name, int maxEntityCount, ACEntityData entityData) {
        super(entityData, world, name, maxEntityCount);
        this.cuboid = cuboid;
    }

    @Override
    public boolean contains(Location location) {
        return cuboid.contains(location);
    }

    @Override
    public List<ACRegionManager.ChunkRef> getChunks() {
        return cuboid.getChunks();
    }

    @Override
    public void doSpawn() {
        spawnInCuboid(cuboid);
    }
}
