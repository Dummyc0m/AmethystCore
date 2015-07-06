package com.dummyc0m.amethystcore.framework.region;

import com.dummyc0m.amethystcore.framework.region.ACRegionManager.ChunkRef;
import com.dummyc0m.amethystcore.util.ACFormat;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public abstract class ACCuboidRegion implements ACRegion {
    private String world;
    private ACCuboid cuboid;
    private String name;
    private String displayName;
    private String greeting;
    private String farewell;

    public ACCuboidRegion(String world, ACCuboid cuboid, String name, String displayName) {
        this.world = world;
        this.cuboid = cuboid;
        this.name = name;
        this.displayName = displayName;
        this.greeting = ACFormat.GRAY + "[已进入" + displayName + "]";
        this.farewell = ACFormat.GRAY + "[已离开" + displayName + "]";
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
