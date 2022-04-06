package cput.ac.za.Domain.Entity;

/**
 * Joshua Julies
 * 220102473
 * The Payment entity
 */

public class Payment {
    public String paymentID;
    public String studentAccountID;
    public String paymentDate;
    public int paymentAmount;

    public Payment(PaymentBuilder paymentBuilder){
        this.paymentID = paymentID;
        this.studentAccountID = studentAccountID;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentID(String paymentID){
        return paymentID;
    }

    public String getStudentAccountID(String studentAccountID){
        return studentAccountID;
    }

    public String setPaymentDate(String paymentDate){
        return paymentDate;
    }

    public int getPaymentAmount(int paymentAmount){
        return paymentAmount;
    }

    public static class PaymentBuilder{
        public String paymentID;
        public String studentAccountID;
        public String paymentDate;
        public int paymentAmount;

        public PaymentBuilder(String paymentID, int paymentAmount){
            this.paymentID = paymentID;
            this.paymentAmount = paymentAmount;
        }

        public PaymentBuilder setPaymentID(String paymentID){
            this.paymentID = paymentID;
            return this;
        }

        public PaymentBuilder setStudentAccountID(String studentAccountID){
            this.studentAccountID = studentAccountID;
            return this;
        }

        public PaymentBuilder setPaymentDate(String paymentDate){
            this.paymentDate = paymentDate;
            return this;
        }

        public PaymentBuilder setPaymentAmount(int paymentAmount){
            this.paymentAmount = paymentAmount;
            return this;
        }

        public Payment buildPayment(){
            Payment payment = new Payment(this);
            return payment;
        }
    }
}
