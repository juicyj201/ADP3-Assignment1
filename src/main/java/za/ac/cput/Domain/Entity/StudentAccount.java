package za.ac.cput.Domain.Entity;

import javax.persistence.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Entity
 *
 *
 */
@Entity
@Table(name = "StudentAccount")
public class StudentAccount {

    @Id
    @Column(name = "studAccountNumber")
    private Long studAccountNumber;
    @Column(name = "studentID")
    private String studentID;
    @Column(name = "amountDue")
    private String amountDue;
    @Column(name = "amountPaid")
    private String amountPaid;

    private StudentAccount(StudentAccountBuilder builder){
        this.studAccountNumber = Long.valueOf(builder.studAccountNumber);
        this.studentID = builder.studentID;
        this.amountDue = builder.amountDue;
        this.amountPaid = builder.amountPaid;
    }

    public StudentAccount() {
    }

    public Long getStudAccountNumber() {
        return studAccountNumber;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getAmountDue() {
        return amountDue;
    }

    public String getAmountPaid() {
        return amountPaid;
    }

    @Override
    public String toString() {
        return "StudentAccount{" + "StudAccountNumber='" + studAccountNumber + '\'' + ", StudentID='" + studentID + '\'' + ", AmountDue=" + amountDue + ", AmountPaid=" + amountPaid + '}';
    }

    public static class StudentAccountBuilder{
        private long studAccountNumber;
        private String studentID;
        private String amountDue;
        private String amountPaid;

//        public StudentAccountBuilder() {
//            this.studAccountNumber = studAccountNumber;
//            this.studentID = studentID;
//            this.amountDue = amountDue;
//            this.amountPaid = amountPaid;
//        }


        public StudentAccountBuilder createStudAccountNumber(long studAccountNumber) {
            this.studAccountNumber = studAccountNumber;
            return this;
        }

        public StudentAccountBuilder getStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentAccountBuilder createAmountDue(String amountDue) {
            this.amountDue = amountDue;
            return this;
        }

        public StudentAccountBuilder createAmountPaid(String amountPaid) {
            this.amountPaid = amountPaid;
            return this;
        }

    public StudentAccount copy(StudentAccount studentAccount)
    {
        this.studAccountNumber = studentAccount.studAccountNumber;
        this.studentID = studentAccount.studentID;
        this.amountDue = studentAccount.amountDue;
        this.amountPaid = studentAccount.amountPaid;
        return studentAccount;
    }

        public StudentAccount builder() {
            return new StudentAccount(this);
        }

}
 }