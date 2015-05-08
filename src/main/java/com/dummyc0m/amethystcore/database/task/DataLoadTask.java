package com.dummyc0m.amethystcore.database.task;

import com.dummyc0m.amethystcore.database.ACDataProcessor;
import com.dummyc0m.amethystcore.database.ACPlayerData;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 * Created by Dummyc0m on 4/18/15.
 */
public class DataLoadTask implements Runnable {
    private UUID uuid;
    private PreparedStatement preparedStatement;
    private ACDataProcessor processor;

    public DataLoadTask(UUID uuid, ACDataProcessor processor, PreparedStatement preparedStatement) {
        this.uuid = uuid;
        this.preparedStatement = preparedStatement;
        this.processor = processor;
    }

    /**
     * module=?, experience=?, expLevel=?, amethyst=?, fluorite=?, gunLevel=?, ammo=?, flame=?,
     * firework=?, gemBullet=?, enderPearl=?, railgun=?, explosive=?, textFlare=?, flareContent=?,
     * jetpackLevel=?, validUntil=?, autoReload=?
     */
    @Override
    public void run() {
        try {
            this.preparedStatement.setString(1, this.uuid.toString());
            ResultSet resultSet = this.preparedStatement.executeQuery();
            this.processor.queueProcess(new ACPlayerData(this.uuid, resultSet.getString("module"), resultSet.getInt("experience"), resultSet.getInt("expLevel"),
                    resultSet.getInt("amethyst"), resultSet.getInt("fluorite"), resultSet.getInt("gunLevel"), resultSet.getInt("ammo"), resultSet.getInt("flame"), resultSet.getInt("firework"),
                    resultSet.getInt("gemBullet"), resultSet.getInt("enderPearl"), resultSet.getInt("railgun"), resultSet.getInt("explosive"), resultSet.getInt("textFlare"),
                    resultSet.getString("flareContent"), resultSet.getInt("jetpackLevel"), resultSet.getLong("validUntil"), resultSet.getBoolean("autoReload")));
        } catch (SQLException e) {
            throw new RuntimeException("Error loading player data", e);
        }
    }
}
