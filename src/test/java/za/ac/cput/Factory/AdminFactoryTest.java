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

    @Test
    public void testBuildAdmin(){
        try {
            Assertions.assertTrue(factory.buildAdmin("21", "Manager", "John", "Banks") == admin);
            Assertions.assertNotNull(factory);
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
