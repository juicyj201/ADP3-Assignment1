package cput.ac.za.Domain.Builder;

import cput.ac.za.Domain.Entity.Payment;

public class FirstPaymentBuilder implements PaymentBuilder{
    private Payment payment;

    public FirstPaymentBuilder() {
        this.payment = new Payment();
    }

    @Override
    public void createPaymentID() {
        payment.setPaymentID("PURCH01");
    }

    @Override
    public void createStudentAccountID() {
        payment.setStudentAccountID("STUD01");
    }

    @Override
    public void createPaymentDate() {
        payment.setPaymentDate("04/April/2022");
    }

    @Override
    public void createPaymentAmount() {
        payment.setPaymentAmount(2300);
    }

    @Override
    public Payment getProduct(){
        return payment;
    }
}
