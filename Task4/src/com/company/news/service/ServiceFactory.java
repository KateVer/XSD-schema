package com.company.news.service;

import com.company.news.dao.impl.NewsDAOImpl;
import com.company.news.service.impl.NewsServiceImpl;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class ServiceFactory {
    private IService newsService = new NewsServiceImpl();


    public IService getNewsService(){
        return newsService;
    }

    public static ServiceFactory getInstance(){
        return new ServiceFactory();
    }
}
