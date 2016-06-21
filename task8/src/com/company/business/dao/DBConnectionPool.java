package com.company.business.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
//Singleton realization
public class DBConnectionPool {

    private final int count = 10;
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock writeLock = rwl.writeLock();

    private Map<Connection, Boolean> connections = new HashMap<Connection, Boolean>();

    private static DBConnectionPool dbConnectionPool = new DBConnectionPool( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private DBConnectionPool(){ }

    /* Static 'instance' method */
    public static DBConnectionPool getInstance( ) {
        return dbConnectionPool;
    }

    public Connection createConnection() throws DBConnectionPoolException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("MySQL JDBC Driver Registered!");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Online_shop","root", "root");
        } catch (SQLException e) {
            throw new DBConnectionPoolException("SQLException Connection Failed! Check output console", e);
        }
        catch (ClassNotFoundException e) {
            throw new DBConnectionPoolException("ClassNotFoundException Where is your MySQL JDBC Driver?", e);
        }
        return connection;
    }

    public Connection getConnection() throws DBConnectionPoolException {
        try{
            if(connections.isEmpty()){
                for(int i = 0; i < count; i++){
                    Connection con = null;
                        con = createConnection();
                    connections.put(con, true);
                }
            }
        } catch (DBConnectionPoolException e) {
            throw new DBConnectionPoolException("Could not create Connection", e);
        }
        Connection connection = null;
        writeLock.lock();

        for (Connection con: connections.keySet()) {
            if (connections.get(con)){
                connection = con;
                connections.put(con, false);
                break;
            }
        }

        writeLock.unlock();

        return connection;
    }

    public void closeConnection(Connection con){
        connections.put(con, true);
    }


}
