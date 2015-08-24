package com.dummyc0m.amethystcore.region.spawner;

import com.dummyc0m.amethystcore.region.cuboid.IACCuboid;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dummyc0m on 8/16/15.
 */
public abstract class ACAbstractSpawner implements IACSpawner {
    private final World world;
    private final String name;
    private final int maxEntityCount;
    private final List<WeakReference<Entity>> entities;
    private final ACEntityData entityData;

    public ACAbstractSpawner(ACEntityData entityData, String world, String name, int maxEntityCount) {
        this.entityData = entityData;
        this.world = Bukkit.getWorld(world);
        this.name = name;
        this.entities = new ArrayList<>();
        this.maxEntityCount = maxEntityCount;
    }

    @Override
    public World getWorld() {
        return world;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMaxEntities() {
        return maxEntityCount;
    }

    protected void spawnInCuboid(IACCuboid cuboid) {
        if (checkEntityLimit()) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            Location location = getSpawnLocation(cuboid.getRandomPoint());
            if (location != null) {
                entityData.spawnEntity(location);
            }
        }
    }

    /**
     * @param location initial random point
     * @return modified point, null if not spawnable
     */
    private Location getSpawnLocation(Location location) {
        int highestY = world.getHighestBlockYAt(location);
        if (highestY < location.getBlockY()) {
            return new Location(world, location.getX(), highestY, location.getZ());
        }
        int x = location.getBlockX();
        int z = location.getBlockZ();
        //Potential NPE
        if (world.getBlockAt(location).getType().isTransparent()) {
            for (int i = location.getBlockY(); i > 0; i--) {
                if (!world.getBlockAt(x, i, z).getType().isTransparent()) {
                    //Absolutely terrible way of doing it. TODO
                    if (world.getBlockAt(x, i + 1, z).getType().isTransparent() && world.getBlockAt(x, i + 2, z).getType().isTransparent()) {
                        return new Location(world, location.getX(), i + 1, location.getZ());
                    }
                }
            }
        }
        return null;
    }

    /**
     * @return true if limit reached
     */
    private boolean checkEntityLimit() {
        cleanList();
        return entities.size() >= maxEntityCount;
    }

    private void cleanList() {
        Iterator<WeakReference<Entity>> iterator = entities.iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next().get();
            if (entity == null || entity.isValid()) {
                iterator.remove();
            }
        }
    }
}
