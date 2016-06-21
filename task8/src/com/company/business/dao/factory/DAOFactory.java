package com.company.business.dao.factory;


import com.company.business.dao.IMakerDAO;
import com.company.business.dao.IUserDAO;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public abstract class DAOFactory {
    private static final MySqlDAOFactory mySqlDAOFactory = new MySqlDAOFactory();


    public static MySqlDAOFactory getMySqlDAOFactory() {
        return mySqlDAOFactory;
    }

    public abstract IUserDAO getIUserDAO();
    public abstract IMakerDAO getIMakerDAO();



}
