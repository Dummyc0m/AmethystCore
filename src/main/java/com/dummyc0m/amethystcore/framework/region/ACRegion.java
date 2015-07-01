package com.dummyc0m.amethystcore.framework.region;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
}
