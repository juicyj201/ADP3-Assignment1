package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Service.Impl.StudentService;
import za.ac.cput.Service.Impl.StudentServiceImpl;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Controller Test
 *
 */

public class StudentControllerTest {
    private Student student;
    private StudentService service = StudentServiceImpl.getService();
    private String localhost;
    @Autowired private StudentController studentController;

    @BeforeEach
    void setUp() {
        assertNotNull(studentController);
        this.student = StudentFactory.createStudent("219113140", "Peter", "Griffin", "Male", "47", "Peanuts");
    }

    @Test
    public void testSave(){
        assertNotNull(this.service.save(student));
        String url = localhost + "/save";
        System.out.println(url);
        ResponseEntity<Student> response = this.studentController.save(student);
        System.out.println(response);
        assertAll(()-> assertEquals(HttpStatus.OK, response.getStatusCode()), ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    public void testRead(){
        assertNotNull(this.service.read(student));
        Student saved = this.service.save(this.student);
        Optional<Student> read = this.service.read(this.student);
        assertAll(() -> Assertions.assertTrue(read.isPresent()), () -> Assertions.assertSame(saved, read.get()));
        System.out.println(saved);
    }

    @Test
    public void testDelete(){
        if(this.service.read(student) != null){
            this.service.delete(student);
        }else{
            throw new NullPointerException("Student not found");
        }
    }

    @Test
    public void testUpdate(){
        if(this.service.read(student) != null){
            this.service.update(student);
        }else{
            throw new NullPointerException("Student not found");
        }
    }

    @Test
    public void testReadAll(){
        assertNotNull(this.service.readAll());
    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }


}
