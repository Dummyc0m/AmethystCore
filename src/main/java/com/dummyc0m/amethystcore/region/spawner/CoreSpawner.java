package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.ChunkRef;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dummyc0m on 8/24/15.
 * Ideally working TODO
 */
public class CoreSpawner {
    private final Map<String, ISpawner> nameSpawnerMap = new HashMap<>();
    private final Map<String, Map<ChunkRef, List<ISpawner>>> worldChunkSpawnerMap = new HashMap<>();

    public void addSpawner(ISpawner spawner) {
        String world = spawner.getWorld().getName();
        Map<ChunkRef, List<ISpawner>> chunkSpawnerMap = worldChunkSpawnerMap.get(world);
        if (chunkSpawnerMap == null) {
            chunkSpawnerMap = new HashMap<>();
            worldChunkSpawnerMap.put(world, chunkSpawnerMap);
        }
        for (ChunkRef chunkRef : spawner.getChunks()) {
            List<ISpawner> spawners = chunkSpawnerMap.get(chunkRef);
            if (spawners == null) {
                spawners = new ArrayList<>();
                chunkSpawnerMap.put(chunkRef, spawners);
            }
            spawners.add(spawner);
        }
        nameSpawnerMap.put(spawner.getName(), spawner);
    }

    public ISpawner removeSpawner(String name) {
        ISpawner spawner = nameSpawnerMap.get(name);
        if (spawner == null) {
            return null;
        }
        String world = spawner.getWorld().getName();
        Map<ChunkRef, List<ISpawner>> chunkSpawnerMap = worldChunkSpawnerMap.get(world);
        for (ChunkRef chunkRef : spawner.getChunks()) {
            List<ISpawner> regions = chunkSpawnerMap.get(chunkRef);
            regions.remove(spawner);
            if (regions.isEmpty()) {
                chunkSpawnerMap.remove(chunkRef);
            }
        }
        return nameSpawnerMap.remove(name);
    }

    public ISpawner getSpawner(Location location) {
        String world = location.getWorld().getName();
        ChunkRef chunkRef = new ChunkRef(location);
        if (!worldChunkSpawnerMap.containsKey(world) || !worldChunkSpawnerMap.get(world).containsKey(chunkRef)) {
            return null;
        }
        for (ISpawner spawner : worldChunkSpawnerMap.get(world).get(chunkRef)) {
            if (spawner.contains(location)) {
                return spawner;
            }
        }
        return null;
    }

    public ISpawner getSpawner(String name) {
        return nameSpawnerMap.get(name);
    }
}
