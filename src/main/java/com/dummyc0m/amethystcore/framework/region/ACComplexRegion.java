package com.dummyc0m.amethystcore.framework.region;

import com.dummyc0m.amethystcore.framework.region.ACRegionManager.ChunkRef;
import com.dummyc0m.amethystcore.util.ACFormat;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public abstract class ACComplexRegion implements ACRegion {
    private final String world;
    private final List<ACCuboid> cuboids;
    private final String name;
    private final String displayName;
    private final String greeting;
    private final String farewell;

    public ACComplexRegion(String world, List<ACCuboid> cuboids, String name, String displayName) {
        this.world = world;
        this.cuboids = cuboids;
        this.name = name;
        this.displayName = displayName;
        this.greeting = ACFormat.GRAY + "[已进入" + displayName + "]";
        this.farewell = ACFormat.GRAY + "[已离开" + displayName + "]";
    }

    @Override
    public boolean contains(Location location) {
        for (ACCuboid cuboid : cuboids) {
            if (cuboid.contains(location)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<ChunkRef> getChunks() {
        List<ChunkRef> chunkRefs = new ArrayList<>();
        for (ACCuboid cuboid : cuboids) {
            chunkRefs.addAll(cuboid.getChunks());
        }
        return chunkRefs;
    }

    @Override
    public String getWorld() {
        return world;
    }

    @Override
    public boolean onEnter(Player player) {
        player.sendMessage(greeting);
        return false;
    }

    @Override
    public boolean onDeparture(Player player) {
        player.sendMessage(farewell);
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDisplayName() {
        return displayName;
    }
}
