package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.ChunkRef;
import com.dummyc0m.amethystcore.region.cuboid.ICuboid;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Dummyc0m on 8/16/15.
 */
public class ACCuboidSpawner extends ACAbstractSpawner {
    private final ICuboid cuboid;

    public ACCuboidSpawner(String world, ICuboid cuboid, String name, int maxEntityCount, ACEntityData entityData) {
        super(entityData, world, name, maxEntityCount);
        this.cuboid = cuboid;
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
    public void doSpawn() {
        spawnInCuboid(cuboid);
    }
}
