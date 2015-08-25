package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.ChunkRef;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.List;

/**
 * Created by Dummyc0m on 8/2/15.
 */
public interface ISpawner {
    boolean contains(Location location);

    List<ChunkRef> getChunks();

    World getWorld();

    String getName();

    int getMaxEntities();

    void doSpawn();
}
