package com.company.news.service;

import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Catalog;
import com.company.news.entity.News;
import com.company.news.entity.SubCategory;
import com.company.news.service.criteria.Criteria;
import com.company.news.service.exception.ServiceException;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public interface IService {
    void saveNewNews(News news, String subCategoryName, String categoryName) throws ServiceException, DAOException, JAXBException;
    List<News> findNews(Criteria criteria) throws ServiceException, DAOException, JAXBException;
}

