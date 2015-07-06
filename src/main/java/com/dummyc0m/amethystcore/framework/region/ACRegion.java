package com.dummyc0m.amethystcore.framework.region;

import com.dummyc0m.amethystcore.framework.region.ACRegionManager.ChunkRef;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public interface ACRegion {
    boolean contains(Location location);

    /*
        return true to forbid entrance
     */
    boolean onEnter(Player player);

    /*
        return true to forbid exit
     */
    boolean onDeparture(Player player);

    List<ChunkRef> getChunks();

    String getWorld();

    String getName();

    String getDisplayName();
}
