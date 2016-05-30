package com.company.news.dao;

import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Catalog;
import com.company.news.entity.News;
import com.company.news.service.criteria.Criteria;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public interface INewsDAO {
    void saveNews(News news, String subCategoryName, String categoryName) throws DAOException, JAXBException;
    List<News> getNews(Criteria criteria) throws DAOException, JAXBException;
}
