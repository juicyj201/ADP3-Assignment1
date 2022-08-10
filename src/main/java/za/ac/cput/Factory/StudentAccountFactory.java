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
    public static StudentAccount createStudentAccount(String StudAccountNumber, String StudentID, String AmountDue, String AmountPaid){

        if(AmountDue == null || AmountPaid == null)
            return null;

        return new StudentAccount.StudentAccountBuilder()
                .setStudAccountNumber(StudAccountNumber)
                .setStudentID(StudentID)
                .setAmountDue(AmountDue)
                .setAmountPaid(AmountPaid)
                .builder();
    }
}
