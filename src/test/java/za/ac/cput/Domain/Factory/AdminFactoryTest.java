package za.ac.cput.Domain.Factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import za.ac.cput.Domain.Entity.Admin;

/**
 * Joshua Julies
 * 220102473
 * The admin factory test fixture
 */

public class AdminFactoryTest {

    private AdminFactory factory = new AdminFactory();
    private AdminFactory factorytest;
    private Admin admin = factory.getAdmin("adminJohn");

    @BeforeAll
    public void setUp(){
        //factory = new AdminFactory();
        factorytest = new AdminFactory();
    }

    @Test
    public void getAdmin(){
        Assert.assertEquals(factory.getAdmin("adminJohn"), admin);
    }
}
