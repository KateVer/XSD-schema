package com.company.business.dao.api;

import com.company.business.model.User;

import java.util.List;

/**
 * Created by kateverbitskaya on 20.06.16.
 */
public interface IUserDAO {

    public User getUserById(int userId);
    public List<User> getAllUser();
    public void create(User user);

}
