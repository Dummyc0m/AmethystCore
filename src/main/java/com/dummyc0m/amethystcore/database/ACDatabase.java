package com.dummyc0m.amethystcore.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dummyc0m on 3/12/15.
 */
public class ACDatabase {
    private boolean isConnected;
    private Connection connection;

    private String type;
    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;

    public ACDatabase(String type, String hostname, int port, String database, String username, String password) {
        this.type = type;
        this.hostname = hostname;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
        this.connect();
    }

    /**
     *
     * @return true if a new connection is opened.
     */
    private boolean connect(){
        if(this.isConnected) return false;

        StringBuilder stringBuilder = new StringBuilder("jdbc:").append(this.type).append("://").append(this.hostname).append(":").append(this.port);
        if(this.database != null){
            stringBuilder.append("/").append(this.database);
        }
        if(this.username != null && this.password != null) {
            try {
                this.connection = DriverManager.getConnection(stringBuilder.toString(), this.username, this.password);
                return this.isConnected = true;
            } catch (SQLException e) {
                throw new RuntimeException("An error occurred when trying to connect to the database", e);
            }
        } else {
            try {
                this.connection = DriverManager.getConnection(stringBuilder.toString());
                return this.isConnected = true;
            } catch (SQLException e) {
                throw new RuntimeException("An error occurred when trying to connect to the database", e);
            }
        }
    }

    /**
     *
     * @return true if the connection is open
     */
    public boolean verifyConnection(){
        if(!this.isConnected) return this.connect();

        try {
            if(!this.connection.isValid(1)){
                this.connection.close();
                this.isConnected = false;
                return this.connect();
            }
        } catch (SQLException e){
            throw new RuntimeException("An error occurred when trying to verify the database connection", e);
        }

        return true;
    }

    public boolean close(){
        if(!this.isConnected) return true;

        try {
            this.connection.close();
            return true;
        } catch(SQLException e){
            throw new RuntimeException("An error occurred when trying to close the database connection", e);
        }
    }

    public Connection getConnection(){
        if(!this.verifyConnection()) throw new RuntimeException("An error occurred when trying to get the database connection.");

        return this.connection;
    }

}
