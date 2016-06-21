package com.company.business.dao.factory;

import com.company.business.dao.IMakerDAO;
import com.company.business.dao.IUserDAO;
import com.company.business.dao.impl.MakerDAOImpl;
import com.company.business.dao.impl.UserDAOImpl;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class MySqlDAOFactory extends DAOFactory {
    private static final IUserDAO userDAO = new UserDAOImpl();
    private static final IMakerDAO makerDAO = new MakerDAOImpl();

    @Override
    public IUserDAO getIUserDAO() {
        return userDAO;
    }

    @Override
    public IMakerDAO getIMakerDAO(){
        return makerDAO;
    }

}
