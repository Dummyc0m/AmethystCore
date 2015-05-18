package com.dummyc0m.amethystcore.database.task;

import com.dummyc0m.amethystcore.database.ACData;
import com.dummyc0m.amethystcore.database.ACDataStorage;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Queue;

/**
 * Created by Dummyc0m on 5/9/15.
 */
public abstract class ACProcessor implements Runnable {
    private ACDataStorage storage;
    private Queue<ACData> processQueue;

    public ACProcessor(ACDataStorage storage, Queue<ACData> processQueue, JavaPlugin plugin) {
        this.storage = storage;
        this.processQueue = processQueue;
    }

    @Override
    public void run() {
        if (this.processQueue.isEmpty()) {
            return;
        }
        this.process(this.storage, this.processQueue.poll());
    }

    public abstract void process(ACDataStorage storage, ACData data);
}
