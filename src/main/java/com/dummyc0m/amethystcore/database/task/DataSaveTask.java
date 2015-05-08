package com.dummyc0m.amethystcore.database.task;

import com.dummyc0m.amethystcore.database.ACDBConnectionManager;
import com.dummyc0m.amethystcore.database.ACPlayerData;

import java.util.UUID;

/**
 * Created by Dummyc0m on 4/18/15.
 */
public class DataSaveTask implements Runnable {
    private UUID uuid;
    private ACPlayerData data;
    private ACDBConnectionManager manager;

    public DataSaveTask(UUID uuid, ACPlayerData data, ACDBConnectionManager manager) {
        this.uuid = uuid;
        this.data = data;
        this.manager = manager;
    }

    @Override
    public void run() {

    }
}
