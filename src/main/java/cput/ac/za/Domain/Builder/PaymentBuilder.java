package cput.ac.za.Domain.Builder;

import cput.ac.za.Domain.Entity.Payment;

public interface PaymentBuilder {
    public void createPaymentID();
    public void createStudentAccountID();
    public void createPaymentDate();
    public void createPaymentAmount();
    public Payment getProduct();
}
