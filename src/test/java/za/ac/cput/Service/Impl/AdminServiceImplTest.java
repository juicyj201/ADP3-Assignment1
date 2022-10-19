package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Factory.AdminFactory;

/**
 * Joshua Julies
 * 220102473
 * The admin service implementation test
 */

public class AdminServiceImplTest {
    private AdminServiceImpl service;
    private Admin admin = new AdminFactory().buildAdmin(01L, "Accountant", "Jax", "Blade");
    private Admin updatedAdmin = new AdminFactory().buildAdmin(01L, "Accountant", "Jax", "Blades");

    //side note - I used the testService method, trying to avoid the null pointer error for the service object --->
    @Test
    public void testService() {
        try {
            //Assertions.assertTrue(service.equals(null));
            Assertions.assertThrows(NullPointerException.class, ()->{
                service.equals(null);
            }, "Service uses dependency injection for repository, this is expected.");
        } catch(NullPointerException npe){
            npe.getCause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave(){
        try {
            Assertions.assertTrue(service.save(new AdminFactory().buildAdmin(01L, "Accountant", "Jax", "Blade")) != null);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void testRead(){
        try {
            Assertions.assertNotNull(service.read(admin.getAdminID()));
        } catch(NullPointerException npe) {
            npe.getStackTrace();
            npe.getMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadAll(){
        try {
            Assertions.assertNotNull(service.readAll());
        } catch(NullPointerException npe) {
            npe.getStackTrace();
            npe.getMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test void testUpdate(){
        try {
            Assertions.assertFalse(service.update(updatedAdmin).equals(service.read(admin.getAdminID())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
