package com.company.business.dao;

import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
//Singleton realization
public class DBConnectionPool {

    private final int count = 10;

    private BlockingQueue<Connection> freeConnectionQueue = new ArrayBlockingQueue<Connection>(count);
    private BlockingQueue<Connection> busyConnectionQueue = new ArrayBlockingQueue<Connection>(count);
    private static DBConnectionPool dbConnectionPool = new DBConnectionPool( );



    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private DBConnectionPool() {

    }

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

        Connection connection = null;
        int conCount = freeConnectionQueue.size() + busyConnectionQueue.size();
        try {
            if (conCount == 0) {
                for (int i = 0; i < count; i++) {
                    Connection con = null;
                    con = createConnection();
                    freeConnectionQueue.add(con);
                }
            }
        } catch (DBConnectionPoolException e) {
            throw new DBConnectionPoolException("DBConnectionPoolException Could not create DBConnectionPool instance", e);
        }

        try {
            connection = freeConnectionQueue.take();
            busyConnectionQueue.add(connection);
        } catch (InterruptedException e) {
            throw new DBConnectionPoolException("InterruptedException Error connecting to the data source", e);
        }

        return connection;
    }

    public void makeFreeConnection(Connection connection){
        busyConnectionQueue.remove(connection);
        freeConnectionQueue.add(connection);
    }

    public void closePoolConnection() throws DBConnectionPoolException {
        try {
            closeQueueConnection(freeConnectionQueue);
            closeQueueConnection(busyConnectionQueue);
        } catch (SQLException e) {
            throw new DBConnectionPoolException("SQLException Could not close connections", e);
        }
    }

    public void closeQueueConnection(BlockingQueue<Connection> connectionQueue) throws SQLException, DBConnectionPoolException {
        Connection connection;
        while ((connection = connectionQueue.poll()) != null){
            if (!connection.getAutoCommit()){
                connection.commit();
            }
            closeConnection(connection);
        }
    }

    public void closeConnection(Connection connection) throws DBConnectionPoolException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DBConnectionPoolException("SQLException Could not close connection", e);
        }
    }

}
