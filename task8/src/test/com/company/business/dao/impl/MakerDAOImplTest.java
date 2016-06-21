package test.com.company.business.dao.impl;

import com.company.business.dao.DAOException;
import com.company.business.dao.impl.MakerDAOImpl;
import com.company.business.model.Maker;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by kateverbitskaya on 21.06.16.
 */
public class MakerDAOImplTest {

    @Test
    public void getAllMaker(){
        MakerDAOImpl makerDAOImpl = new MakerDAOImpl();
        List<Maker> makers = null;
        try {
            makers = makerDAOImpl.getAllMaker();
        } catch (DAOException e) {
            System.out.println("Could not get All users, the log below:" + e);
        }
        Assert.assertNotNull(makers);

    }

}
