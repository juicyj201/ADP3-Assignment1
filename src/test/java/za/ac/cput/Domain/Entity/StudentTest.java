package za.ac.cput.Domain.Entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test() {
        Student student = new Student.StudentBuilder()
                .setStudentID("219113149")
                .setStudFirstName("Keziah")
                .setStudSurname("Robinson")
                .setGender("Female")
                .setAge("21")
                .setAllergies("None")
                .builder();
        System.out.println(student);
    }

    @Test
    void testDisable() {
        assertEquals(student1, student2);
    }

    @AfterAll
    public static void tearDownClass() {
    }
}
