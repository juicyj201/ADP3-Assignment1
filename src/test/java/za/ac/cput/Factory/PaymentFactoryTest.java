package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import za.ac.cput.Domain.Entity.Payment;

/**
 * Joshua Julies
 * 220102473
 * The payment factory test fixture
 */

public class PaymentFactoryTest {
    private PaymentFactory factory = new PaymentFactory();
    private Payment payment = factory.getPayment("P01");

    @BeforeAll
    public void setUp(){
        //factory = new PaymentFactory();
    }

    @Test
    public void test(){
        //Assertions.assertEquals(factory.getPayment("P01"), payment);
        Assertions.assertNotNull(factory);
    }
}
