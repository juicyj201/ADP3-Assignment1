package za.ac.cput.Factory;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Factory
 * 05 April 2021
 *
 */

import za.ac.cput.Domain.Entity.StudentAccount;

public class StudentAccountFactory {
    public static StudentAccount createStudentAccount(long studAccountNumber, String studentID, String amountDue, String amountPaid){

        if(amountDue == null || amountPaid == null)
            return null;

        return new StudentAccount.StudentAccountBuilder()
                .createStudAccountNumber(studAccountNumber)
                .getStudentID(studentID)
                .createAmountDue(amountDue)
                .createAmountPaid(amountPaid)
                .builder();
    }
}
