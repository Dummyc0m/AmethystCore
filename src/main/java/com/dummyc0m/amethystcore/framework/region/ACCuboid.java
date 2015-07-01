package com.dummyc0m.amethystcore.framework.region;

import com.dummyc0m.amethystcore.framework.region.ACRegionManager.ChunkRef;
import org.bukkit.Location;

import java.util.List;

/**
 * Created by Dummyc0m on 6/6/15.
 */
public interface ACCuboid {
    boolean contains(Location location);

    List<ChunkRef> getChunks();
}
