package za.ac.cput.Factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Payment;

/**
 * Joshua Julies
 * 220102473
 * The payment factory test fixture
 */

public class PaymentFactoryTest {
    private PaymentFactory factory = new PaymentFactory();
    private Payment payment = factory.buildPayment(01L,"31","01/01/2022", 200);

    @Test
    public void testBuildPayment(){
        try {
            Assertions.assertTrue(factory.buildPayment(01L, "31", "01/01/2022", 200) == payment);
            Assertions.assertNotNull(factory);
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }

    /**
     //Failing test for an empty payment object created by the factory
     @Test
     public void failingTest() {
     Assertions.assertNotNull(new PaymentFactory().buildPayment(null,null,null, 0));
     Assertions.fail("This test has failed, so objects/attributes of objects of the payment factory cannot be null when using factory.");
     }
     **/
}
