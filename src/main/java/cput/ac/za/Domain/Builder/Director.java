package cput.ac.za.Domain.Builder;

import cput.ac.za.Domain.Entity.Admin;
import cput.ac.za.Domain.Entity.Payment;

public class Director {
    private ManagerBuilder manBuilder;
    private FirstPaymentBuilder fpBuilder;

    public Director(ManagerBuilder manBuilder){
        this.manBuilder = manBuilder;
    }

    public Director(FirstPaymentBuilder fpBuilder){
        this.fpBuilder = fpBuilder;
    }

    public void constructManagerAccount(){
        manBuilder.createAdminID();
        manBuilder.createAdminType();
        manBuilder.createAdminFullName();
    }

    public void constructPayment(){
        fpBuilder.createPaymentID();
        fpBuilder.createStudentAccountID();
        fpBuilder.createPaymentDate();
        fpBuilder.createPaymentAmount();
    }

    public Admin getManager(){
        return manBuilder.getProduct();
    }

    public Payment getPayment(){
        return fpBuilder.getProduct();
    }
}
