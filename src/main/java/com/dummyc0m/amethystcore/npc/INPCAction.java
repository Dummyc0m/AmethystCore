package com.dummyc0m.amethystcore.npc;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

/**
 * Created by Dummyc0m on 8/24/15.
 */
public interface INPCAction {
    void onClick(Player player, Entity villager, Vector position);
}
