package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Student;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Factory Test
 *
 */

class StudentFactoryTest {

    @BeforeEach
    void setUp() {
    }
    @Test
    public void StudentTest() {
        Student student = new Student.StudentBuilder()
                .createStudentID("219113149")
                .createStudFirstName("Keziah")
                .createStudSurname("Robinson")
                .createGender("Female")
                .createAge("21")
                .createAllergies("Bees")
                .builder();
        System.out.println(student);
    }

    @Test
    public void StudentFactoryTest() {
        Student student1 = StudentFactory.createStudent("219113148", "Kessia", "Robertson", "Female", "22", "Peanuts");
        assertNotNull(student1);
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }
}