package cput.ac.za.Domain.Entity;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Entity
 * 05 April 2021
 *
 */

public class StudentAccount {

    private String StudAccountNumber;
    private String StudentID;
    private double AmountDue;
    private double AmountPaid;

    private StudentAccount(StudentAccountBuilder builder){
        this.StudAccountNumber = builder.StudAccountNumber;
        this.StudentID = builder.StudentID;
        this.AmountDue = builder.AmountDue;
        this.AmountPaid = builder.AmountPaid;
    }

    public String setStudAccountNumber(String studAccountNumber) {
        StudAccountNumber = studAccountNumber;
        return studAccountNumber;
    }

    public String setStudentID(String studentID) {
        StudentID = studentID;
        return studentID;

    }

    public double setAmountDue(double amountDue) {
        AmountDue = amountDue;
        return amountDue;
    }

    public double setAmountPaid(double amountPaid) {
        AmountPaid = amountPaid;
        return amountPaid;
    }

    @Override
    public String toString() {
        return "StudentAccount{" + "StudAccountNumber='" + StudAccountNumber + '\'' + ", StudentID='" + StudentID + '\'' + ", AmountDue=" + AmountDue + ", AmountPaid=" + AmountPaid + '}';
    }

    public static class StudentAccountBuilder{
        private String StudAccountNumber;
        private String StudentID;
        private double AmountDue;
        private double AmountPaid;


        public StudentAccountBuilder setStudAccountNumber(String studAccountNumber) {
            StudAccountNumber = studAccountNumber;
            return this;
        }

        public StudentAccountBuilder setStudentID(String studentID) {
            StudentID = studentID;
            return this;
        }

        public StudentAccountBuilder setAmountDue(double amountDue) {
            AmountDue = amountDue;
            return this;
        }

        public StudentAccountBuilder setAmountPaid(double amountPaid) {
            AmountPaid = amountPaid;
            return this;
        }
        public StudentAccount builder() {
            return new StudentAccount(this);
        }
    }

}