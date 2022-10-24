package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.StudentAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.StudentAccountFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Factory Test
 *
 */


class StudentAccountFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void StudentAccountTest(){
        StudentAccount studentAccount = new StudentAccount.StudentAccountBuilder()
                .createStudAccountNumber(21919191)
                .getStudentID("219113149")
                .createAmountDue("12.00")
                .createAmountPaid("12.00")
                .builder();

    }

    @Test
    void StudentAccountFactTest(){
        StudentAccount studentAccount = StudentAccountFactory.createStudentAccount(11111, "219113149", "12.00", "12.00");
        assertNotNull(studentAccount);
        System.out.println(studentAccount);
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }
}