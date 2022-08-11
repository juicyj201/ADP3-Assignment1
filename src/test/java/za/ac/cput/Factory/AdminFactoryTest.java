package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Factory.AdminFactory;

/**
 * Joshua Julies
 * 220102473
 * The admin factory test fixture
 */

public class AdminFactoryTest {

    private AdminFactory factory = new AdminFactory();
    private Admin admin = factory.buildAdmin("21", "Manager", "John", "Banks");

    @BeforeAll
    public void setUp(){
        //factory = new AdminFactory();
    }

    @Test
    public void test(){
        //Assertions.assertEquals(factory.getAdmin("adminJohn"), admin);
        Assertions.assertNotNull(factory);
    }
}