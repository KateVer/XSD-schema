package com.company;

import com.company.business.dao.impl.UserDAOImpl;
import com.company.business.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        UserDAOImpl userDAOImpl = new UserDAOImpl();
        List<User> users = userDAOImpl.getAllUser();
        for (User user : users){
            System.out.println(user.toString());
        }



    }
}
