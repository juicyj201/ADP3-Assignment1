package cput.ac.za.Domain.Entity;

public class Payment {
    public String paymentID;
    public String studentAccountID;
    public String paymentDate;
    public int paymentAmount;

    public void setPaymentID(String paymentID){
        this.paymentID = paymentID;
    }

    public void setStudentAccountID(String studentAccountID){
        this.studentAccountID = studentAccountID;
    }

    public void setPaymentDate(String paymentDate){
        this.paymentDate = paymentDate;
    }

    public void setPaymentAmount(int paymentAmount){
        this.paymentAmount = paymentAmount;
    }

    public Payment getPayment(Payment payment){
        return payment;
    }
}
