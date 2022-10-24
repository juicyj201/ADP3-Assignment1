package za.ac.cput.Factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Admin;

/**
 * Joshua Julies
 * 220102473
 * The admin factory test fixture
 */

public class AdminFactoryTest {
    private AdminFactory factory = new AdminFactory();
    private Admin admin = factory.buildAdmin(21L, "Manager", "John", "Banks");

    @Test
    public void testBuildAdmin(){
        try {
            Assertions.assertTrue(factory.buildAdmin(21L, "Manager", "John", "Banks") == admin);
            Assertions.assertNotNull(factory);
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }

    /**
    //Failing test for an empty admin object created by the factory
    @Test
    public void failingTest() {
        Assertions.assertNotNull(new AdminFactory().buildAdmin(null,null,null,null));
        Assertions.fail("This test has failed, so objects/attributes of objects of the admin factory cannot be null when using factory.");
    }
    **/
}
