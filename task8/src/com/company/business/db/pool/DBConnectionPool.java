package com.company.business.db.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

    private CopyOnWriteArrayList<Connection> connections = new CopyOnWriteArrayList<Connection>();

    private CopyOnWriteArrayList<Boolean> mark = new CopyOnWriteArrayList<Boolean>();

    private static DBConnectionPool dbConnectionPool = new DBConnectionPool( );

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private DBConnectionPool(){ }

    /* Static 'instance' method */
    public static DBConnectionPool getInstance( ) {
        return dbConnectionPool;
    }

    public Connection createConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/Online_shop","root", "root");

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getConnection()throws Exception {

        if(connections.isEmpty()){
            for(int i = 0; i < count; i++){
                try {
                    Connection con = createConnection();
                    connections.add(con);
                    mark.add(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        writeLock.lock();
        Connection connection = null;
        try {
            int index = mark.indexOf(false);
            mark.set(index, true);
            connection = connections.get(index);
        } finally {
            writeLock.unlock();
        }
        return connection;

    }

    public void closeConnection(Connection con){
        int index = connections.indexOf(con);
        mark.set(index, false);
    }


}
