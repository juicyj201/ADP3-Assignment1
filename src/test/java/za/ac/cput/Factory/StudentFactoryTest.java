package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentFactoryTest {


    @BeforeEach
    void setUp() {
    }

    @Test
    public void test(){

        Student student = StudentFactory.createStudent("219113149", "Keziah", "Robinson", "Female", "21", "Null");
        assertNotNull(student);
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }
}