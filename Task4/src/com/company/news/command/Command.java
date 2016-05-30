package com.company.news.command;

import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Request;
import com.company.news.entity.Response;
import com.company.news.service.exception.ServiceException;

import javax.xml.bind.JAXBException;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public interface Command {
    public Response execute(Request request) throws JAXBException, DAOException, ServiceException;
}
