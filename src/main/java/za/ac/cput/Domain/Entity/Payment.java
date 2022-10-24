package za.ac.cput.Domain.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Joshua Julies
 * 220102473
 * The Payment entity
 */

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @Column(name = "paymentID")
    public Long paymentID;
    @Column(name = "studentAccountID")
    public String studentAccountID;
    @Column(name = "paymentDate")
    public String paymentDate;
    @Column(name = "paymentAmount")
    public int paymentAmount;

    public Payment(PaymentBuilder paymentBuilder){
        this.paymentID = paymentBuilder.paymentID;
        this.studentAccountID = paymentBuilder.studentAccountID;
        this.paymentDate = paymentBuilder.paymentDate;
        this.paymentAmount = paymentBuilder.paymentAmount;
    }

    public Payment(){
        //empty constructor
    }

    public void setPaymentID(Long paymentID){
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

    public Long getPaymentID(){
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return paymentAmount == payment.paymentAmount && paymentID.equals(payment.paymentID) && studentAccountID.equals(payment.studentAccountID) && paymentDate.equals(payment.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentID, studentAccountID, paymentDate, paymentAmount);
    }

    @Override
    public String toString(){
        return this.paymentID + ", " + this.studentAccountID + ", " + this.paymentDate + ", " + this.paymentAmount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static class PaymentBuilder{
        public Long paymentID;
        public String studentAccountID;
        public String paymentDate;
        public int paymentAmount;

        public PaymentBuilder(){
            this.paymentID = paymentID;
            this.studentAccountID = studentAccountID;
            this.paymentDate = paymentDate;
            this.paymentAmount = paymentAmount;
        }

        public PaymentBuilder createID(Long paymentID, int paymentAmount){
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
