package com.dummyc0m.amethystcore.framework.region;

import com.dummyc0m.amethystcore.framework.region.ACRegionManager.ChunkRef;
import com.dummyc0m.amethystcore.util.ACFormat;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Dummyc0m on 7/1/15.
 */
public abstract class ACCuboidRegion implements ACRegion {
    private final String world;
    private final ACCuboid cuboid;
    private final String name;
    private final String displayName;
    private final String greeting;
    private final String farewell;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ACCuboidRegion that = (ACCuboidRegion) o;

        return new EqualsBuilder()
                .append(world, that.world)
                .append(cuboid, that.cuboid)
                .append(name, that.name)
                .append(displayName, that.displayName)
                .append(greeting, that.greeting)
                .append(farewell, that.farewell)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(world)
                .append(cuboid)
                .append(name)
                .append(displayName)
                .append(greeting)
                .append(farewell)
                .toHashCode();
    }
}
