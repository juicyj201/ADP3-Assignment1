package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                .setStudAccountNumber("21919191")
                .setStudentID("219113149")
                .setAmountDue("12.00")
                .setAmountPaid("12.00")
                .builder();
    }

    @AfterAll
    public static void tearDownClass() {
    }
}