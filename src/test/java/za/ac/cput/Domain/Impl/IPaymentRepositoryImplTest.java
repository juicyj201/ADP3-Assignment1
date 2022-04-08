package za.ac.cput.Domain.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Impl.PaymentRepositoryImpl;

/**
 * Joshua Julies
 * 220102473
 * The payment repository test fixture
 */

public class IPaymentRepositoryImplTest {
    private PaymentRepositoryImpl repo = new PaymentRepositoryImpl();
    private PaymentRepositoryImpl repo2 = null;
    private Payment payment;// = new Admin.AdminBuilder("Max", "Flight").build();
    private PaymentRepositoryImpl repo3 = new PaymentRepositoryImpl();
    private PaymentRepositoryImpl repo4 = new PaymentRepositoryImpl();

    @BeforeAll
    public void setUp(){
        payment = new Payment.PaymentBuilder("P02", 2500).build();
        //repo = AdminRepositoryImpl.getRepo();
        repo2.create("P02", payment);
        repo3.create("P02", payment);
    }

    @Test
    public void getRepo(){
        Assert.assertNotNull(repo);
    }

    @Test
    public void create(){
        Assert.assertEquals(repo3.create("P02", payment), repo2);
    }

}
