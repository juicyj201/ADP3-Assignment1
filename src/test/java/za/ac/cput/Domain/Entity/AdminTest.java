package za.ac.cput.Domain.Entity;

import za.ac.cput.Domain.Entity.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;

public class AdminTest {
    private Admin admin;

    @BeforeEach
    public void setUp(){
        admin = new Admin.AdminBuilder("Name", "Surname").build();
        admin.setAdminID("adJacobOwn");
        admin.setAdminType("Business Owner");
        //admin.setAdminFullName("Jacob", "Lattimus");
    }
    
    @Test
    @DisplayName("Testing the general admin object")
    public void testGeneral(){
        Assert.assertNotNull(admin);
    }
}
