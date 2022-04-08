package za.ac.cput.Domain.Repository;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentRepository Test
 * 05 April 2021
 *
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Impl.StudentRepositoryImpl;

public class StudentRepositoryTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        StudentRepositoryImpl repository = StudentRepositoryImpl.getRepository();
    }

    @AfterAll
    public static void tearDownClass() {
    }
}
