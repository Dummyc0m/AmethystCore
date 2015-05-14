package com.dummyc0m.amethystcore.database;

import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Dummyc0m on 5/10/15.
 */
public interface ACDataStorage {
    void queueLoad(UUID uuid);

    void queueSave(Player player);
}
