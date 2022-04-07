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

    public Payment(){
        this.paymentID = paymentID;
        this.studentAccountID = studentAccountID;
        this.paymentDate = paymentDate;
        this.paymentAmount = paymentAmount;
    }

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

    public String getPaymentID(){
        return paymentID;
    }

    public String getStudentAccountID(){
        return studentAccountID;
    }

    public String getPaymentDate(){
        return paymentDate;
    }

    public int getPaymentAmount(){
        return paymentAmount;
    }

}
