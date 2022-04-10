package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

/**
 * Joshua Julies
 * 220102473
 * The payment test fixture
 */

public class PaymentTest {
    private Payment payment = new Payment.PaymentBuilder("P03", 1900).createStudentAccountID("21919191").createPaymentDate("06/April/2022").build();
    private Payment payment2;

    @BeforeAll
    public void setUp(){
        //admin = new Admin.AdminBuilder("John", "Grisham").createAdminID("adJohnMan").createAdminType("Manager").build();
    }

    @Test
    public void test(){
        Assertions.assertEquals(new Payment.PaymentBuilder("P03", 1900).createStudentAccountID("21919191").createPaymentDate("06/April/2022").build(), payment);
    }
}
