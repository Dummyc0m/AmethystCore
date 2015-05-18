package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.database.task.ACProcessor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by Dummyc0m on 5/10/15.
 */
public abstract class ACPlayerDatabase extends ACDatabase implements ACDataStorage {
    private JavaPlugin plugin;
    private ACProcessor processor;

    private ExecutorService loaderPool = new ThreadPoolExecutor(2, 40, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(40));
    private ExecutorService saverPool = new ThreadPoolExecutor(2, 40, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(40));
    private Queue<ACData> processQueue = new ConcurrentLinkedQueue<>();

    private Map<UUID, ACData> dataMap = new HashMap<>();

    public ACPlayerDatabase(String type, String hostname, int port, String database, String username, String password, JavaPlugin plugin) {
        super(type, hostname, port, database, username, password);
        this.plugin = plugin;
    }

    @Override
    public abstract void queueLoad(UUID uuid);

    @Override
    public void queueProcess(ACData data) {
        this.processQueue.offer(data);
    }

    @Override
    public abstract void queueSave(Player player);
}
