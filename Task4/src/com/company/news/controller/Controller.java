package com.company.news.controller;

import com.company.news.command.Command;
import com.company.news.command.impl.SaveNewNewsCommand;
import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Request;
import com.company.news.entity.Response;
import com.company.news.service.exception.ServiceException;

import javax.xml.bind.JAXBException;

/**
 * Created by kateverbitskaya on 29.05.16.
 */
public class Controller {
    CommandHelper helper = new CommandHelper();


    public Response doAction(Request request) throws ServiceException, JAXBException, DAOException {
        String commandName = request.getCommandName();
        Command command = helper.getCommand(commandName);



            Response response = command.execute(request);
        return response;
    }
}
