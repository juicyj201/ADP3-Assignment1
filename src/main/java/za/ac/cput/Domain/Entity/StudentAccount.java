package za.ac.cput.Domain.Entity;

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
    private String AmountDue;
    private String AmountPaid;

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

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String setAmountDue(String amountDue) {
        AmountDue = amountDue;
        return amountDue;
    }

    public String setAmountPaid(String amountPaid) {
        AmountPaid = amountPaid;
        return amountPaid;
    }

    public String getStudAccountNumber() {
        return StudAccountNumber;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getAmountDue() {
        return AmountDue;
    }

    public String getAmountPaid() {
        return AmountPaid;
    }

    @Override
    public String toString() {
        return "StudentAccount{" + "StudAccountNumber='" + StudAccountNumber + '\'' + ", StudentID='" + StudentID + '\'' + ", AmountDue=" + AmountDue + ", AmountPaid=" + AmountPaid + '}';
    }

    public static class StudentAccountBuilder{
        private String StudAccountNumber;
        private String StudentID;
        private String AmountDue;
        private String AmountPaid;


        public StudentAccountBuilder setStudAccountNumber(String studAccountNumber) {
            StudAccountNumber = studAccountNumber;
            return this;
        }

        public StudentAccountBuilder setStudentID(String studentID) {
            StudentID = studentID;
            return this;
        }

        public StudentAccountBuilder setAmountDue(String amountDue) {
            AmountDue = amountDue;
            return this;
        }

        public StudentAccountBuilder setAmountPaid(String amountPaid) {
            AmountPaid = amountPaid;
            return this;
        }

    public StudentAccount copy(StudentAccount studentAccount)
    {
        this.StudAccountNumber = studentAccount.StudAccountNumber;
        this.StudentID = studentAccount.StudentID;
        this.AmountDue = studentAccount.AmountDue;
        this.AmountPaid = studentAccount.AmountPaid;
        return studentAccount;
    }

        public StudentAccount builder() {
            return new StudentAccount(this);
        }

}
 }