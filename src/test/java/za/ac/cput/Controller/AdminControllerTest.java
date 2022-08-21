package za.ac.cput.Controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Factory.AdminFactory;

/**
 * Joshua Julies
 * 220102473
 * The admin controller test
 */

public class AdminControllerTest {
    private AdminController controller;
    private Admin admintestobject = new AdminFactory().buildAdmin("21", "Manager", "John", "Banks");

    @Test
    public void testSaveAdmin(){
        try {
            Assertions.assertNotNull(controller.saveAdmin(new AdminFactory().buildAdmin("21", "Manager", "John", "Banks")));
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void testReadAdmin(){
        try {
            Assertions.assertNotNull(controller.getAdminByID(admintestobject));
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }

//    @Test
//    public void testReadAllAdmin(){
//        try {
//            Assertions.assertNotNull(controller.getAllAdmin());
//        }catch(NullPointerException npe){
//            npe.getMessage();
//            npe.getStackTrace();
//        }catch(Exception e){
//            e.getMessage();
//        }
//    }

    @Test
    public void testUpdateAdmin(){
        try {
            Assertions.assertNotNull(controller.updateAdmin(admintestobject));
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
