package com.dummyc0m.amethystcore.region;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dummyc0m on 6/4/15.
 */
public class CoreRegion {
    private final Map<String, IRegion> nameRegionMap = new HashMap<>();
    private final Map<String, Map<ChunkRef, List<IRegion>>> worldChunkRegionMap = new HashMap<>();

    public void addRegion(IRegion region) {
        String world = region.getWorld();
        Map<ChunkRef, List<IRegion>> chunkRegionMap = worldChunkRegionMap.get(world);
        if (chunkRegionMap == null) {
            chunkRegionMap = new HashMap<>();
            worldChunkRegionMap.put(world, chunkRegionMap);
        }
        for (ChunkRef chunkRef : region.getChunks()) {
            List<IRegion> regions = chunkRegionMap.get(chunkRef);
            if (regions == null) {
                regions = new ArrayList<>();
                chunkRegionMap.put(chunkRef, regions);
            }
            regions.add(region);
        }
        nameRegionMap.put(region.getName(), region);
    }

    public IRegion removeRegion(String name) {
        IRegion region = nameRegionMap.get(name);
        if (region == null) {
            return null;
        }
        String world = region.getWorld();
        Map<ChunkRef, List<IRegion>> chunkRegionMap = worldChunkRegionMap.get(world);
        for (ChunkRef chunkRef : region.getChunks()) {
            List<IRegion> regions = chunkRegionMap.get(chunkRef);
            regions.remove(region);
            if (regions.isEmpty()) {
                chunkRegionMap.remove(chunkRef);
            }
        }
        return nameRegionMap.remove(name);
    }

    public IRegion getRegion(Location location) {
        String world = location.getWorld().getName();
        ChunkRef chunkRef = new ChunkRef(location);
        if (!worldChunkRegionMap.containsKey(world) || !worldChunkRegionMap.get(world).containsKey(chunkRef)) {
            return null;
        }
        for (IRegion region : worldChunkRegionMap.get(world).get(chunkRef)) {
            if (region.contains(location)) {
                return region;
            }
        }
        return null;
    }

    public IRegion getRegion(String name) {
        return nameRegionMap.get(name);
    }


}