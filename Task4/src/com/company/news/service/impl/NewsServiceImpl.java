package com.company.news.service.impl;

import com.company.news.dao.DAOFactory;
import com.company.news.dao.INewsDAO;
import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Catalog;
import com.company.news.entity.News;
import com.company.news.service.IService;
import com.company.news.service.criteria.Criteria;
import com.company.news.service.exception.ServiceException;

import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class NewsServiceImpl implements IService {



    @Override
    public void saveNewNews(News news, String subCategoryName, String categoryName) throws ServiceException, DAOException, JAXBException {
        DAOFactory factory = DAOFactory.getInstance();
        INewsDAO newsDAO = factory.getNewsDAO();
        try {
            newsDAO.saveNews(news, subCategoryName, categoryName);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
    @Override
    public List<News> findNews(Criteria criteria) throws ServiceException, DAOException, JAXBException {

        DAOFactory factory = DAOFactory.getInstance();
        INewsDAO newsDAO = factory.getNewsDAO();
        List<News> news = newsDAO.getNews(criteria);
        return  news;

    }
}
