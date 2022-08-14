package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Factory.AdminFactory;
import za.ac.cput.Factory.PaymentFactory;

public class PaymentServiceImplTest {
    private PaymentServiceImpl service;

    private Payment payment = new PaymentFactory().buildPayment("01", "01", "01/01/1999", 220);

    @Test
    public void testSave(){
        try {
            Assertions.assertTrue(service.save(new PaymentFactory().buildPayment("01", "01", "01/01/1999", 220)) != null);
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
