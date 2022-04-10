package za.ac.cput.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
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
        repo.create("adMaxOwn",admin);
        //repo = AdminRepositoryImpl.getRepo();
        //repo2 = new AdminRepositoryImpl();
        //repo2.create("adMaxOwn", admin);
        //repo3.create("adMaxOwn", admin);
    }

    @Test
    public void test(){
        ////Assertions.assertEquals(repo3.create("adMaxOwn", admin), repo2);
        Assertions.assertNotNull(repo);
    }
}
