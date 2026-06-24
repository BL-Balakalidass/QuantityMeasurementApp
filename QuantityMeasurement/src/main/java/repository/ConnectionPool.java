package main.java.repository;

import main.java.config.ApplicationConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {

    private final Queue<Connection> connections =
            new LinkedList<>();

    public ConnectionPool(int poolSize) {

        try {

            for(int i = 0; i < poolSize; i++) {

                connections.add(
                        DriverManager.getConnection(
                                ApplicationConfig.get("db.url"),
                                ApplicationConfig.get("db.username"),
                                ApplicationConfig.get("db.password")
                        )
                );
            }

        } catch (SQLException e) {

            throw new DatabaseException(
                    "Failed to initialize connection pool",
                    e
            );
        }
    }

    public ConnectionPool(String s, String sa, String s1, int i) {
    }

    public synchronized Connection acquire() {

        if(connections.isEmpty()) {

            throw new DatabaseException(
                    "Connection Pool Exhausted"
            );
        }

        return connections.poll();
    }

    public synchronized void release(
            Connection connection) {

        if(connection != null) {
            connections.offer(connection);
        }
    }

    public synchronized int availableConnections() {
        return connections.size();
    }

    public Connection getConnection() {
        return null;
    }
}