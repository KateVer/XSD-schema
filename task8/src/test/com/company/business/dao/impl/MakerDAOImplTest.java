package test.com.company.business.dao.impl;

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
        List<Maker> makers = makerDAOImpl.getAllMaker();
        Assert.assertNotNull(makers);

    }

}
