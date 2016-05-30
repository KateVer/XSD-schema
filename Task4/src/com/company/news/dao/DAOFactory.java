package com.company.news.dao;

import com.company.news.dao.impl.NewsDAOImpl;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class DAOFactory {
    private INewsDAO newsDAO = new NewsDAOImpl();


    public INewsDAO getNewsDAO(){
        return newsDAO;
    }

    public static DAOFactory getInstance(){
        return new DAOFactory();
    }
}
