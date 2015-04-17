package com.dummyc0m.amethystcore.database;

import com.mysql.jdbc.PreparedStatement;

import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public class ACDataProcessor implements Runnable {
    private Queue<UUID> taskQueue = new ConcurrentLinkedQueue<>();
    private ACDBConnectionManager manager;
    private ACDatabase database;
    private String tableName;
    private PreparedStatement fetchStatement;

    public ACDataProcessor(ACDBConnectionManager manager, ACDatabase database, String tableName) {
        this.manager = manager;
        this.tableName = tableName;
        this.database = database;
    }

    @Override
    public void run() {
        String uuid = taskQueue.poll().toString();

    }
}
