package com.company.business.dao.impl;

import com.company.business.common.EntityConstant;
import com.company.business.dao.DAOException;
import com.company.business.dao.DBConnectionPoolException;
import com.company.business.dao.IUserDAO;
import com.company.business.dao.DBConnectionPool;
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

    private DBConnectionPool dbConnectionPool = DBConnectionPool.getInstance();

    @Override
    public User getUserById(int userId) {
        return null;
    }

    @Override
    public List<User> getAllUser() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<User>  userList = new ArrayList<User>();


        try {
            connection = dbConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.GET_ALL_USERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                userList.add(parseRSElementToUser(resultSet));
            }
        } catch (SQLException e) {
            throw new DAOException("SQLException: Wrong Sql statement or could not execute query", e);
        }
        catch (DBConnectionPoolException e) {
            throw new DAOException("DBConnectionPoolException: exception in pool", e);
        }
        finally{
            dbConnectionPool.makeFreeConnection(connection);
        }

        return userList;
    }

    private User parseRSElementToUser(ResultSet rs) throws DAOException {
        User user = new User();
        try {
            user.setUserId(rs.getInt(EntityConstant.USER_ID));
            user.setName(rs.getString(EntityConstant.NAME));
            user.setAdminYN(rs.getString(EntityConstant.ADMIN_YN));
            user.setPhone(rs.getString(EntityConstant.PHONE));
            user.setEmail(rs.getString(EntityConstant.EMAIL));
        } catch (SQLException e) {
            throw new DAOException("SQLException: could not get data from resul", e);
        }
        return user;
    }




}
