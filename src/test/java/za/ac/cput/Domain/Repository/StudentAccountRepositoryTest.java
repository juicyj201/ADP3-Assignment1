package za.ac.cput.Domain.Repository;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccountRepository Test
 * 05 April 2021
 *
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Impl.StudentAccountRepositoryImpl;


public class StudentAccountRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        StudentAccountRepositoryImpl repository = StudentAccountRepositoryImpl.getRepository();
    }

    @AfterAll
    public static void tearDownClass() {
    }
}
