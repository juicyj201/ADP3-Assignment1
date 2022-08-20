package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Service Implementation Test
 *
 */

public class StudentServiceImplTest {

    private static StudentRepository studentRepository;
    private List<Student> studentList;
    private StudentServiceImpl studentService;
    private Student student;
    private za.ac.cput.Domain.Entity.Student Student;


    @BeforeEach
    void setUp() {
}

    @Test
    void save() {
        Student saved = this.studentService.save(this.student);
        assertNotNull(saved);
        System.out.println("Student has been saved");
    }

    @Test
    void read() {
        Student saved = this.studentService.save(this.student);
        Optional<Student> read = this.studentService.read(this.student);
        System.out.println(saved);
    }

    @Test
    void delete() {
        Student saved = this.studentService.save(this.student);
        this.studentService.delete(this.student);
        assertEquals(0, studentList.size());
        System.out.println("Student was deleted");

    }

    @Test
    void readAll() {
        Student saved = this.studentService.save(this.student);
        List<Student> studentList = studentService.readAll();
        assertEquals(0, studentList.size());
        System.out.println(studentList);
    }


    @AfterEach
    void tearDown() {
    }


}
