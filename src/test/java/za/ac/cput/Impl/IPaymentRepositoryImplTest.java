package za.ac.cput.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
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
    private Payment payment;

    @BeforeAll
    public void setUp(){
        payment = new Payment.PaymentBuilder("P02", 2500).build();
        repo.create("P02", payment);
        //repo = AdminRepositoryImpl.getRepo();
        //repo2.create("P02", payment);
        //repo3.create("P02", payment);
    }

    @Test
    public void getRepo(){
        Assertions.assertNotNull(repo);
    }

}
