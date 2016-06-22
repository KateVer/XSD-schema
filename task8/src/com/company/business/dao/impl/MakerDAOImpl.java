package com.company.business.dao.impl;

import com.company.business.common.EntityConstant;
import com.company.business.dao.DAOException;
import com.company.business.dao.DBConnectionPoolException;
import com.company.business.dao.IMakerDAO;
import com.company.business.dao.DBConnectionPool;
import com.company.business.model.Maker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class MakerDAOImpl implements IMakerDAO {

   private DBConnectionPool dbConnectionPool = DBConnectionPool.getInstance();



    @Override
    public List<Maker> getAllMaker() throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Maker> makerList = new ArrayList<>();


        try {
            connection = dbConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatement.GET_ALL_MAKERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                makerList.add(parseRSElementToMaker(resultSet));
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

        return makerList;
    }

    private Maker parseRSElementToMaker(ResultSet rs) throws DAOException{
        Maker maker = new Maker();
        try {
            maker.setMakerId(rs.getInt(EntityConstant.MAKER_ID));
            maker.setCountry(rs.getString(EntityConstant.COUNTRY));
            maker.setCompany(rs.getString(EntityConstant.COMPANY));
            maker.setContacts(rs.getString(EntityConstant.CONTACTS));
        } catch (SQLException e) {
            throw new DAOException("SQLException: could not get data from resul", e);
        }
        return maker;
    }





}
