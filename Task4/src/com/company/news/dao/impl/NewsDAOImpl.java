package com.company.news.dao.impl;

import com.company.news.common.AppConstants;
import com.company.news.dao.INewsDAO;
import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Catalog;
import com.company.news.entity.Category;
import com.company.news.entity.News;
import com.company.news.entity.SubCategory;
import com.company.news.parser.IParser;
import com.company.news.parser.impl.JaxbParser;
import com.company.news.service.criteria.Criteria;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class NewsDAOImpl implements INewsDAO {
    @Override
    public void saveNews(News news, String subCategoryName, String categoryName) throws DAOException, JAXBException {
        IParser parser = new JaxbParser();
        Catalog catalog = getAll();
        for (int i = 0; i < catalog.getCategoryList().size(); i++){
            Category category = catalog.getCategoryList().get(i);
            if (category.getName().equals(categoryName)) {
                for (int j = 0; j <  category.getSubCategoryList().size(); j++) {
                    SubCategory subCategory = catalog.getCategoryList().get(i).getSubCategoryList().get(j);
                    if (subCategory.getName().equals(subCategoryName)){
                        catalog.getCategoryList().get(i).getSubCategoryList().get(j).getNews().add(news);
                    }
                }
            }
        }
        parser.saveObject(new File("src/resources.xml"), catalog);
    }

    @Override
    public List<News> getNews(Criteria criteria) throws DAOException, JAXBException {
        IParser parser = new JaxbParser();
        Catalog catalog = (Catalog) parser.getObject(new File("src/resources.xml"), Catalog.class);
        for (Category category : catalog.getCategoryList()){
            String fCategoryName = (String) criteria.getFilter().get(AppConstants.ELEMENT_CATEGORY);
            if (fCategoryName.equals(category.getName())){
                for (SubCategory subCategory : category.getSubCategoryList()){
                    String fSubCategoryName = (String) criteria.getFilter().get(AppConstants.ELEMENT_SUBCATEGORY);
                    if (subCategory.getName().equals(fSubCategoryName)){
                        return subCategory.getNews();
                    }
                }
            }
        }
        return new ArrayList<News>();

    }


    public Catalog getAll() throws DAOException, JAXBException {
        IParser parser = new JaxbParser();
        Catalog catalog = (Catalog) parser.getObject(new File("src/resources.xml"), Catalog.class);
        return catalog;

    }
}
