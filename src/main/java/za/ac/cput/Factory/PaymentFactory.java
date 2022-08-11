package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Payment;

/**
 * Joshua Julies
 * 220102473
 * The payment factory
 */

public class PaymentFactory {
    public Payment buildPayment(String paymentID, String studentAccountID, String paymentDate, int paymentAmount) {
        Payment payment = new Payment.PaymentBuilder()
                .createID(paymentID, paymentAmount)
                .createStudentAccountID(studentAccountID)
                .createPaymentDate(paymentDate)
                .build();

        return payment;
    }
}
