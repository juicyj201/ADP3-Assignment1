package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Factory.PaymentFactory;

/**
 * Joshua Julies
 * 220102473
 * The admin entity
 */

public class AdminServiceImplTest {
    private AdminServiceImpl service;

    private Admin admin = new AdminFactory().buildAdmin("01", "Accountant", "Jax", "Blade");

    @Test
    public void testSave(){
        try {
            Assertions.assertTrue(service.save(new AdminFactory().buildAdmin("01", "Accountant", "Jax", "Blade")) != null);
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
