package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.AmethystCore;
import com.dummyc0m.amethystcore.database.task.DataLoadTask;
import com.dummyc0m.amethystcore.database.task.DataSaveTask;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Dummyc0m on 4/12/15.
 */
public class ACTable {
    private static ACDatabase INSTANCE;
    private AmethystCore coreInstance = AmethystCore.getInstance();
    private ACDBConnectionManager manager;
    private Map<UUID, ACPlayerData> dataMap = new HashMap<>();
    private ACDataProcessor processor;
    private Queue<ACPlayerData> processorQueue = new ConcurrentLinkedQueue<>();
    private ExecutorService executors = Executors.newCachedThreadPool();
    private PreparedStatement queryStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;

    public ACDatabase(String type, String hostname, int port, String database, String username, String password, String tableName) {
        this.manager = new ACDBConnectionManager(type, hostname, port, database, username, password);
        this.processor = new ACDataProcessor(manager, this, tableName);
        this.coreInstance.getServer().getScheduler().runTaskTimer(AmethystCore.getInstance(), processor, 1, 5);
        try {
            this.queryStatement = this.manager.getConnection().prepareStatement("SELECT * FROM " + tableName + " WHERE uuid=?");
            this.insertStatement = this.manager.getConnection().prepareStatement("INSERT INTO " + tableName + " (uuid,module,experience,expLevel,amethyst,fluorite,gunLevel,ammo,flame,firework,gemBullet,enderPearl,railgun,explosive,textFlare,flareContent,jetpackLevel,validUntil,autoReload) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            this.updateStatement = this.manager.getConnection().prepareStatement("UPDATE " + tableName + " SET module=?, experience=?, expLevel=?, amethyst=?, fluorite=?, gunLevel=?, ammo=?, flame=?, firework=?, gemBullet=?, enderPearl=?, railgun=?, explosive=?, textFlare=?, flareContent=?, jetpackLevel=?, validUntil=?, autoReload=? WHERE uuid=?");
        } catch (SQLException e) {
            throw new RuntimeException("Error creating statements", e);
        }
        INSTANCE = this;
    }

    public static ACDatabase getInstance() {
        return INSTANCE;
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

    public void queueLoad(UUID uuid) {
        this.processor.queueFetch(uuid);
    }

    protected void startLoadTask(UUID uuid) {
        this.executors.submit(new DataLoadTask(uuid, this.processor, this.queryStatement));
    }

    protected void startSaveTask(UUID uuid) {
        this.executors.submit(new DataSaveTask(uuid, this.dataMap.get(uuid), this.manager));
        this.dataMap.remove(uuid);
    }

}
