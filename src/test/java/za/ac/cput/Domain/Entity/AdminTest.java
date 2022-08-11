package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

/**
 * Joshua Julies
 * 220102473
 * The admin test fixture
 */

public class AdminTest {
    private Admin admin = new Admin.AdminBuilder().createAdminName("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build();
    private Admin admin2;

    @BeforeAll
    public void setUp(){
        //admin = new Admin.AdminBuilder("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build();
    }

    @Test
    public void test(){
        Assertions.assertEquals(admin2 = new Admin.AdminBuilder().createAdminName("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build(), admin);
    }

}
