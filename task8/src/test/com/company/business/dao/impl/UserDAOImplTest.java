package test.com.company.business.dao.impl;

import com.company.business.dao.impl.UserDAOImpl;
import com.company.business.model.User;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class UserDAOImplTest {

    @Test
    public void getAllUser(){
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        List<User> users = userDAOImpl.getAllUser();
        Assert.assertNotNull(users);
        Assert.assertTrue(users.size() > 0);
    }

}
