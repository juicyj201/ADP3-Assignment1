package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Joshua Julies
 * 220102473
 * The admin test fixture
 */

public class AdminTest {
    private Admin admin = new Admin.AdminBuilder().createAdminName("John", "Grisham").createAdminID(01L).createAdminType("Manager").build();
    private Admin admin2;

    @Test
    public void testEquals() {
        try{
            Assertions.assertTrue(admin.equals(new Admin.AdminBuilder().createAdminName("John", "Grisham").createAdminID(01L).createAdminType("Manager").build()));
        }catch(NullPointerException npe){
            npe.getStackTrace();
            npe.getMessage();
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void testBuild(){
        try{
            Assertions.assertNotNull(new Admin.AdminBuilder().createAdminName("John", "Grisham").createAdminID(01L).createAdminType("Manager").build());
        }catch(NullPointerException npe){
            npe.getStackTrace();
            npe.getMessage();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
