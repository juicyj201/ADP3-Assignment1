package cput.ac.za.Factory;

import cput.ac.za.Domain.Entity.Payment;

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
