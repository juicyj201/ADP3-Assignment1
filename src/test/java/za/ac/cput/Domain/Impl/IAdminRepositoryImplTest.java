package za.ac.cput.Domain.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Impl.AdminRepositoryImpl;

import java.util.Map;

/**
 * Joshua Julies
 * 220102473
 * The admin repository test fixture
 */

public class IAdminRepositoryImplTest {
    private AdminRepositoryImpl repo = new AdminRepositoryImpl();
    private AdminRepositoryImpl repo2;
    private Admin admin;// = new Admin.AdminBuilder("Max", "Flight").build();
    private Admin adminnew;
    private AdminRepositoryImpl repo3 = new AdminRepositoryImpl();

    @BeforeAll
    public void setUp(){
        admin = new Admin.AdminBuilder("Max", "Flight").build();
        adminnew = new Admin.AdminBuilder("Dusty", "Blinder").build();
        //repo = AdminRepositoryImpl.getRepo();
        repo2 = new AdminRepositoryImpl();
        repo2.create("adMaxOwn", admin);
        repo3.create("adMaxOwn", admin);
    }

    @Test
    public void getRepo(){
        Assert.assertNotNull(repo);
    }

    @Test
    public void create(){
        Assert.assertEquals(repo3.create("adMaxOwn", admin), repo2);
    }
}
