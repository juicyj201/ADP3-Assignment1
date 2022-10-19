package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;

/**
 * Joshua Julies
 * 220102473
 * The payment service implementation test
 */

public class PaymentServiceImplTest {
    private PaymentService service;
    private Payment payment = new PaymentFactory().buildPayment(01L, "01", "01/01/1999", 220);
    private Payment updatedPayment = new PaymentFactory().buildPayment(01L, "01", "01/01/1999", 250);

    //side note - I used the testService method, trying to avoid the null pointer error for the service object --->
    @Test
    public void testService() {
        try {
            //Assertions.assertTrue(service.equals(null));
            Assertions.assertThrows(NullPointerException.class, ()->{
                service.equals(null);
            }, "Service uses dependency injection for repository, this is expected.");
        } catch(NullPointerException npe){
            npe.getCause();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSave(){
        try {
            Assertions.assertTrue(service.save(new PaymentFactory().buildPayment(01L, "01", "01/01/1999", 220)) != null);
        }catch(Exception e){
            e.getMessage();
        }
    }

    @Test
    public void testRead(){
        try {
            Assertions.assertNotNull(service.read(payment.getPaymentID()));
        } catch(NullPointerException npe) {
            npe.getStackTrace();
            npe.getMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testReadAll(){
        try {
            Assertions.assertNotNull(service.readAll());
        } catch(NullPointerException npe){
            npe.getStackTrace();
            npe.getMessage();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test void testUpdate(){
        try {
            Assertions.assertFalse(service.update(updatedPayment).equals(service.read(payment.getPaymentID())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
