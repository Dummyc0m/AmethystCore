package com.dummyc0m.amethystcore.database;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public class ACDataLoader implements Runnable {
    private Queue<UUID> taskQueue = new ConcurrentLinkedQueue<>();
    private ACDBConnectionManager manager;
    private String tableName;

    public ACDataLoader(ACDBConnectionManager manager, String tableName) {
        this.manager = manager;
        this.tableName = tableName;
    }

    @Override
    public void run() {

    }
}
