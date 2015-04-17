package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.AmethystCore;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public class ACDatabase {
    private ACDBConnectionManager manager;
    private Map<UUID, ACPlayerData> dataMap = new ConcurrentHashMap<>();
    private ACDataProcessor processor;

    public ACDatabase(ACDBConnectionManager manager, String tableName) {
        this.manager = manager;
        this.processor = new ACDataProcessor(manager, this, tableName);
        AmethystCore.getInstance().getServer().getScheduler().runTaskTimer(AmethystCore.getInstance(), processor, 0, 5);
    }

    public void addData(UUID uuid, ACPlayerData data) {
        if (this.dataMap.containsKey(uuid)) {
            this.dataMap.remove(uuid);
        }
        this.dataMap.put(uuid, data);
    }

    public void discardData(UUID uuid) {
        this.dataMap.remove(uuid);
    }


}
