package za.ac.cput.Domain.Factory;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import za.ac.cput.Domain.Entity.Payment;

/**
 * Joshua Julies
 * 220102473
 * The payment factory test fixture
 */

public class PaymentFactoryTest {
    private PaymentFactory factory = new PaymentFactory();
    private PaymentFactory factory2;
    private Payment payment = factory.getPayment("P01");

    @BeforeClass
    public void setUp(){
        //factory = new PaymentFactory();
        factory2 = new PaymentFactory();
    }

    @Test
    public void getPayment(){
        Assert.assertEquals(factory.getPayment("P01"), payment);
    }
}
