package com.company.business.dao.impl;

import com.company.business.dao.IMakerDAO;
import com.company.business.db.pool.DBConnectionPool;
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

    DBConnectionPool dbConnectionPool = DBConnectionPool.getInstance();



    @Override
    public List<Maker> getAllMaker() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Maker> makerList = new ArrayList<>();


        try {
            connection = dbConnectionPool.getConnection();
            preparedStatement = connection.prepareStatement(SQLStatements.GET_ALL_MAKERS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                makerList.add(parseRSElementToMaker(resultSet));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            dbConnectionPool.closeConnection(connection);
        }

        return makerList;
    }

    private Maker parseRSElementToMaker(ResultSet rs){
        Maker maker = new Maker();
        try {
            maker.setMakerId(rs.getInt("Maker_id"));
            maker.setCountry(rs.getString("Country"));
            maker.setCompany(rs.getString("Company"));
            maker.setContacts(rs.getString("Contacts"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maker;
    }





}
