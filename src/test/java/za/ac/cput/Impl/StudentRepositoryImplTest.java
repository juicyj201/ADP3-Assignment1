package za.ac.cput.Impl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Domain.Factory.StudentFactory;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentRepository Test
 * 05 April 2021
 *
 */



public class StudentRepositoryImplTest {

    public static StudentRepositoryImpl repository = StudentRepositoryImpl.getRepository();
    public static Student student = StudentFactory
            .createStudent("219113149", "Keziah", "Robinson", "Female", "21", "None");


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create(){
        Student created = repository.create("001", student);
        assertEquals(student.getStudentID(), created.getStudentID());
        System.out.println("Student created: " + created);
    }

    @Test
    void read(){
        Student read = repository.read(student.getStudentID());
        assertNotNull(read);
    }

    @Test
    void update(){
    }

    @Test
    void delete(){
    }

    @Test
    void getAll(){
        System.out.println(repository.getAll());
    }

    @Test
    public void test(){
        StudentAccountRepositoryImpl repository = StudentAccountRepositoryImpl.getRepository();
    }

    @AfterAll
    public static void tearDownClass() {
    }

}
