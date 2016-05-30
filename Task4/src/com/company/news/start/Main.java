package com.company.news.start;

import com.company.news.controller.Controller;
import com.company.news.dao.exception.DAOException;
import com.company.news.entity.Request;
import com.company.news.entity.Response;
import com.company.news.service.exception.ServiceException;
import com.company.news.view.View;

import javax.xml.bind.JAXBException;

public class Main {

    public static void main(String[] args) throws JAXBException, ServiceException, DAOException {

        Controller controller = new Controller();
        View view = new View();
        Request request = view.doUserActionSave();
       // Request request = view.doUserActionFind();
        Response response = controller.doAction(request);
        System.out.println(response);
    }


}