package cput.ac.za.Domain.Factory;

import cput.ac.za.Domain.Builder.Director;
import cput.ac.za.Domain.Builder.FirstPaymentBuilder;
import cput.ac.za.Domain.Builder.ManagerBuilder;
import cput.ac.za.Domain.Entity.Payment;

public class PaymentFactory {
    public Payment getPayment(String choice){
        if(choice.equalsIgnoreCase("P01")){
            FirstPaymentBuilder payBuilder = new FirstPaymentBuilder();
            Director director = new Director(payBuilder);
            director.constructPayment();

            return director.getPayment();
        }
        else{
            return null;
        }
    }
}
