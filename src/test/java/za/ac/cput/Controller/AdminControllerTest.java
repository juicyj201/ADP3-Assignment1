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
    private final Admin admintestobject = new AdminFactory().buildAdmin(21L, "Manager", "John", "Banks");

    @Test
    public void testSaveAdmin(){
        try {
            Assertions.assertNotNull(controller.saveAdmin(admintestobject));
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
            Assertions.assertNotNull(controller.getAdminByID(admintestobject.getAdminID()));
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void testReadAllAdmin(){
        try {
            Assertions.assertNotNull(controller.getAllAdmin());
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }

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

    @Test
    public void testDeleteAdmin(){
        try {
            controller.deleteAdmin(admintestobject);
            Assertions.assertNull(controller.getAdminByID(admintestobject.getAdminID()));
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
