package za.ac.cput.Domain.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Joshua Julies
 * 220102473
 * The Payment entity
 */

@Entity
@Table(name = "payment")
public class Payment {
    @Id
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

    public Payment(){

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

    @Override
    public String toString(){
        return this.paymentID + ", " + this.studentAccountID + ", " + this.paymentDate + ", " + this.paymentAmount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.clone();
    }

    public static class PaymentBuilder{
        public String paymentID;
        public String studentAccountID;
        public String paymentDate;
        public int paymentAmount;

        public PaymentBuilder(){
            this.paymentID = paymentID;
            this.studentAccountID = studentAccountID;
            this.paymentDate = paymentDate;
            this.paymentAmount = paymentAmount;
        }

        public PaymentBuilder createID(String paymentID, int paymentAmount){
            this.paymentID = paymentID;
            this.paymentAmount = paymentAmount;
            return this;
        }

        public PaymentBuilder createStudentAccountID(String studentAccountID){
            this.studentAccountID = studentAccountID;
            return this;
        }

        public PaymentBuilder createPaymentDate(String paymentDate){
            this.paymentDate = paymentDate;
            return this;
        }

        public Payment build(){
            Payment payment = new Payment(this);
            return payment;
        }
    }

}
