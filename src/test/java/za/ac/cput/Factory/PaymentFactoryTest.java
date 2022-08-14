package za.ac.cput.Factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;

/**
 * Joshua Julies
 * 220102473
 * The payment factory test fixture
 */

public class PaymentFactoryTest {
    private PaymentFactory factory = new PaymentFactory();
    private Payment payment = factory.buildPayment("01","31","01/01/2022", 200);

    @Test
    public void testBuildPayment(){
        try {
            Assertions.assertTrue(factory.buildPayment("01", "31", "01/01/2022", 200) == payment);
            Assertions.assertNotNull(factory);
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
