package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Test
 *
 */

class StudentAccountTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        StudentAccount studentAccount = new StudentAccount.StudentAccountBuilder()
                .createStudAccountNumber("21919191")
                .getStudentID("219113149")
                .createAmountDue("12.00")
                .createAmountPaid("12.00")
                .builder();
    }

    @AfterAll
    public static void tearDownClass() {
    }
}