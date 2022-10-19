package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Joshua Julies
 * 220102473
 * The payment test fixture
 */

public class PaymentTest {
    private Payment payment = new Payment.PaymentBuilder().createID(03L, 1900).createStudentAccountID("21919191").createPaymentDate("06/April/2022").build();
    private Payment payment2;

    @Test
    public void testEquals(){
        try{
            Assertions.assertTrue(payment.equals(new Payment.PaymentBuilder().createID(03L, 1900).createStudentAccountID("21919191").createPaymentDate("06/April/2022").build()));
        }catch(NullPointerException npe){
            npe.getStackTrace();npe.getMessage();
        }
        catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void testBuild(){
        try{
            Assertions.assertNotNull(new Payment.PaymentBuilder().createID(03L, 1900).createStudentAccountID("21919191").createPaymentDate("06/April/2022").build());
        }catch(NullPointerException npe){
            npe.getStackTrace();
            npe.getMessage();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
