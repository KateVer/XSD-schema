package com.company;

import com.company.business.dao.IMakerDAO;
import com.company.business.dao.IUserDAO;
import com.company.business.dao.factory.DAOFactory;
import com.company.business.model.Maker;
import com.company.business.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here


        DAOFactory daoFactory = DAOFactory.getMySqlDAOFactory();

        IUserDAO userDAO = daoFactory.getIUserDAO();
        List<User> users = userDAO.getAllUser();
        for (User user : users){
            System.out.println(user.toString());
        }



        IMakerDAO makerDAO = daoFactory.getIMakerDAO();
        List<Maker> makers = makerDAO.getAllMaker();
        for (Maker maker : makers){
            System.out.println(maker.toString());
        }



    }
}
