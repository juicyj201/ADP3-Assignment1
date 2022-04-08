package za.ac.cput.Domain.Factory;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccountFactory Test
 * 05 April 2021
 *
 */

import za.ac.cput.Domain.Entity.StudentAccount;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentAccountFactoryTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void test(){
        StudentAccount studentAccount = StudentAccountFactory.createStudentAccount("001", "219113149", "12.00", "12.00");
        assertNotNull(studentAccount);
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }
}