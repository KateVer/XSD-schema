package com.company.business.dao.impl;

import com.company.business.dao.api.IUserDAO;
import com.company.business.db.pool.DBConnectionPool;
import com.company.business.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kateverbitskaya on 20.06.16.
 */
public class UserDAOImpl implements IUserDAO {

    DBConnectionPool dbConnectionPool = DBConnectionPool.getInstance();

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User>  userList = new ArrayList<User>();


        try {
            connection = dbConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatements.GET_ALL_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userList.add(parseRSElementToUser(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            dbConnectionPool.closeConnection(connection);
        }

        return userList;
    }

    private User parseRSElementToUser(ResultSet rs){
        User user = new User();
        try {
            user.setUserId(rs.getInt("User_id"));
            user.setName(rs.getString("name"));
            user.setHashPass(rs.getLong("hash(pass)"));
            user.setAdminYN(rs.getString("adminY_N"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void create(User user) {

    }



}
