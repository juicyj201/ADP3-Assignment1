package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Payment;

/**
 * Joshua Julies
 * 220102473
 * The payment factory
 */

public class PaymentFactory {
    public Payment getPayment(String choice){
        if(choice.equalsIgnoreCase("P01")){
            Payment payment;
            payment = new Payment.PaymentBuilder("P01", 2300).build();

            return payment;
        }
        else{
            return null;
        }
    }
}
