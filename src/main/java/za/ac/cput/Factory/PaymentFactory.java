package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Domain.Entity.Util.Validation;

/**
 * Joshua Julies
 * 220102473
 * The payment factory
 */

public class PaymentFactory {
    public Payment buildPayment(Long paymentID, String studentAccountID, String paymentDate, int paymentAmount) {
        Payment payment = new Payment.PaymentBuilder()
                .createID(paymentID, paymentAmount)
                .createStudentAccountID(studentAccountID)
                .createPaymentDate(paymentDate)
                .build();

        if(Validation.checkPaymentNull(payment)) {
            throw new NullPointerException("This payment object is null");
        }else if (Validation.checkStringNullOrEmpty(payment.getPaymentID().toString(), payment.studentAccountID, payment.paymentDate) || Validation.checkAttributeEmpty(payment.getPaymentAmount())) {
            throw new NullPointerException("The attribute(s) of this payment object are null");
        }else {
            return payment;
        }
    }
}
