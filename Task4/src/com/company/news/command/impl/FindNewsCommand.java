package com.company.news.command.impl;

import com.company.news.command.Command;
import com.company.news.common.AppConstants;
import com.company.news.dao.exception.DAOException;
import com.company.news.entity.News;
import com.company.news.entity.Request;
import com.company.news.entity.Response;
import com.company.news.service.IService;
import com.company.news.service.ServiceFactory;
import com.company.news.service.criteria.Criteria;
import com.company.news.service.exception.ServiceException;

import javax.xml.bind.JAXBException;
import java.util.List;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class FindNewsCommand implements Command {

    @Override
    public Response execute(Request request) throws JAXBException, DAOException, ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IService newsService = serviceFactory.getNewsService();
        Criteria criteria = new Criteria();
        criteria.put(AppConstants.ELEMENT_CATEGORY, request.getCategoryName());
        criteria.put(AppConstants.ELEMENT_SUBCATEGORY, request.getSubCategoryName());
        List<News> newsList = newsService.findNews(criteria);
        return new Response(newsList);
    }
}
