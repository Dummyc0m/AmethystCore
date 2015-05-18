package com.dummyc0m.amethystcore.database.task;

import com.dummyc0m.amethystcore.database.ACDataStorage;

import java.sql.PreparedStatement;

/**
 * Created by Dummyc0m on 5/9/15.
 */
public abstract class ACSaver implements Runnable {
    private ACDataStorage storage;
    private PreparedStatement preparedStatement;

    public ACSaver(ACDataStorage storage, PreparedStatement preparedStatement) {
        this.storage = storage;
        this.preparedStatement = preparedStatement;
    }

    @Override
    public void run() {
        this.save(this.storage, this.preparedStatement);
    }

    public abstract void save(ACDataStorage storage, PreparedStatement preparedStatement);

}
