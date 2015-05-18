package com.dummyc0m.amethystcore.database.task;

import com.dummyc0m.amethystcore.database.ACDataStorage;

import java.sql.PreparedStatement;

/**
 * Created by Dummyc0m on 5/9/15.
 */
public abstract class ACLoader implements Runnable {
    private ACDataStorage storage;
    private PreparedStatement preparedStatement;

    public ACLoader(ACDataStorage storage, PreparedStatement preparedStatement) {
        this.storage = storage;
        this.preparedStatement = preparedStatement;
    }

    @Override
    public void run() {
        this.load(this.storage, this.preparedStatement);
    }

    public abstract void load(ACDataStorage storage, PreparedStatement preparedStatement);

}
