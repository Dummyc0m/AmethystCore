package com.dummyc0m.amethystcore.database;

import com.dummyc0m.amethystcore.database.task.ACLoader;
import com.dummyc0m.amethystcore.database.task.ACProcessor;
import com.dummyc0m.amethystcore.database.task.ACSaver;

/**
 * Created by Dummyc0m on 5/10/15.
 */
public class ACPlayerDatabase extends ACDatabase {
    private ACLoader loader;
    private ACProcessor processor;
    private ACSaver saver;

    public ACPlayerDatabase(String type, String hostname, int port, String database, String username, String password) {
        super(type, hostname, port, database, username, password);
    }

}
