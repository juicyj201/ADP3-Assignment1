package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Payment;
import za.ac.cput.Domain.Entity.Util.Validation;

/**
 * Joshua Julies
 * 220102473
 * The payment factory
 */

public class PaymentFactory {
    /**
     * @method buildPayment
     * --------------------
     * This method allows for the unlinked creation of admin objects.
     * It's use is however currently not that important. Once the
     * creation of database entities from this factory using a
     * mini-system has been designed, it will have more functionality
     *
     * @param paymentID - This is the PK of the payment entity
     * @param studentAccountID - This is the related FK of the student account
     * @param paymentDate - This is the date that the payment had been made
     * @param paymentAmount - This is the amount of the deposit
     * @return - The return object is a newly built payment entity
     */
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
