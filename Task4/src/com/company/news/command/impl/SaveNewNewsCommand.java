package com.company.news.command.impl;

import com.company.news.command.Command;
import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Request;
import com.company.news.entity.Response;
import com.company.news.service.IService;
import com.company.news.service.ServiceFactory;
import com.company.news.service.exception.ServiceException;

import javax.xml.bind.JAXBException;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class SaveNewNewsCommand implements Command {
    @Override
    public Response execute(Request request) throws JAXBException, DAOException, ServiceException {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        IService newsService = serviceFactory.getNewsService();
        newsService.saveNewNews(request.getNews(),request.getSubCategoryName(),request.getCategoryName());
        return new Response();
    }
}
