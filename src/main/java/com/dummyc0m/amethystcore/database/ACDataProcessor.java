package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.framework.module.ACModuleHandler;
import org.bukkit.Server;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public class ACDataProcessor implements Runnable {
    private Queue<UUID> fetchQueue = new LinkedList<>();
    private Queue<ACPlayerData> processQueue = new ConcurrentLinkedQueue<>();
    private ACModuleHandler moduleHandler = ACModuleHandler.getInstance();
    private ACDatabase database;
    private Server server;

    public ACDataProcessor(ACDBConnectionManager manager, ACDatabase database, String tableName) {
        this.database = database;
    }

    public void queueFetch(UUID uuid) {
        this.fetchQueue.offer(uuid);
    }

    public void queueProcess(ACPlayerData data) {
        this.processQueue.offer(data);
    }

    @Override
    public void run() {
        if (this.fetchQueue.peek() != null) {
            this.database.startLoadTask(this.fetchQueue.poll());
        } else if (this.processQueue.peek() != null) {
            ACPlayerData data = this.processQueue.poll();
            UUID uuid = data.getPlayerUUID();
            this.database.addData(uuid, data);
            this.moduleHandler.getModule(data.getModule()).onLogin(this.server.getPlayer(uuid), data);
        }

    }

}
