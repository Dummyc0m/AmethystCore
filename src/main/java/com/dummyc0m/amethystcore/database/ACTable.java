package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.database.task.ACProcessor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.*;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public abstract class ACTable implements ACDataStorage {
    private ACDatabase database;
    private JavaPlugin plugin;
    private String tableName;
    private ACProcessor processor;

    private ExecutorService loaderPool = new ThreadPoolExecutor(2, 40, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(40));
    private ExecutorService saverPool = new ThreadPoolExecutor(2, 40, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(40));
    private Queue<ACData> processQueue = new ConcurrentLinkedQueue<>();

    private Map<UUID, ACData> dataMap = new HashMap<>();

    public ACTable(ACDatabase database, String tableName, JavaPlugin plugin) {
        this.database = database;
        this.tableName = tableName;
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

    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return this.database.getConnection().prepareStatement(sql);
    }

}
