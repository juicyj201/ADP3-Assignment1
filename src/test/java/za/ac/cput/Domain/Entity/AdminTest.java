package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

/**
 * Joshua Julies
 * 220102473
 * The admin test fixture
 */

public class AdminTest {
    private Admin admin = new Admin.AdminBuilder("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build();
    private Admin admin2;

    @BeforeClass
    public void setUp(){
        //admin = new Admin.AdminBuilder("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build();
    }

    @Test
    public void test(){
        Assert.assertEquals(admin2 = new Admin.AdminBuilder("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build(), admin);
    }

}
