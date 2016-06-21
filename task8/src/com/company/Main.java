package com.company;

import com.company.business.dao.DAOException;
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
        List<User> users = null;
        try {
            users = userDAO.getAllUser();
        } catch (DAOException e) {
            System.out.println("Could not get All users, the log below:" + e);
        }
        for (User user : users){
            System.out.println(user.toString());
        }



        IMakerDAO makerDAO = daoFactory.getIMakerDAO();
        List<Maker> makers = null;
        try {
            makers = makerDAO.getAllMaker();
        } catch (DAOException e) {
            System.out.println("Could not get All makers, the log below:" + e);
        }
        for (Maker maker : makers){
            System.out.println(maker.toString());
        }



    }
}
