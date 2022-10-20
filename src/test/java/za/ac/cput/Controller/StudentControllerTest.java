package za.ac.cput.Controller;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Factory.StudentFactory;
import za.ac.cput.Service.Impl.StudentService;

import java.util.Optional;



import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * Keziah Robinson
 * 219113149
 * Student  Controller Test
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;
    private Student studenta ;
    @LocalServerPort
    private int port;
    private  String localhost;
    @Autowired
    private TestRestTemplate restTemplate;
@BeforeEach
    public void setUp(){
    assertNotNull(studentController);
    this.studenta = StudentFactory.createStudent(219113140, "Peter", "Griffin", "Male", "47", "Peanuts");
    this.localhost = "http://localhost:"+this.port+"/student/";
}

    @Test
    public void testSave(){
        String url = localhost + "save/";
        System.out.println("Student to save: " + this.studenta);
        ResponseEntity<Student>response = this.restTemplate.postForEntity(url, this.studenta,Student.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response),
                ()-> assertNotNull(response.getBody())
        );
        System.out.printf(String.valueOf(response.getBody()));
//        assertEquals("219113140", postResponse);
    }

    @Test
    void save() {
        String url = localhost + "save/";
        System.out.println("Student to save: " + this.studenta);
        ResponseEntity<Student>response = this.restTemplate.postForEntity(url, this.studenta,Student.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response),
                ()-> assertNotNull(response.getBody())
        );
        System.out.printf(String.valueOf(response.getBody()));
    }

    @Test
    void read() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
//        String url = localhost + "/save";
//        System.out.println(url);
//        try {
//            Assertions.assertNotNull(studentController.save(studenta));
//        }catch(NullPointerException nullPointerException){
//
//            nullPointerException.getMessage();
//            nullPointerException.getStackTrace();
//        }

//        Assertions.assertNotNull(studentController.save(studenta));
//        ResponseEntity<Student> response = studentController.save(studenta);
//        System.out.println(response);
//        assertAll(()-> assertEquals(HttpStatus.OK, response.getStatusCode()), ()-> assertNotNull(response.getBody())
////        );
//    }


//    @Test
//    public void testRead(){
//        assertNotNull(service.read(String.valueOf(student)));
//        Student saved = service.save(this.student);
//        Optional<Student> read = service.read(String.valueOf(this.student));
//        assertAll(() -> Assertions.assertTrue(read.isPresent()), () -> Assertions.assertSame(saved, read.get()));
//        System.out.println(saved);
//    }
//
//    @Test
//    public void testDelete(){
//        if(this.service.read(String.valueOf(student)).isPresent()){
//            this.service.delete(student);
//        }else{
//            throw new NullPointerException("Student not found");
//        }

//        String url = localhost + "delete/" + this.student.getStudentID();
//        this.restTemplate
//                .W(username, password)
//                .delete(url);
//    }
//
//    @Test
//    public void testUpdate(){
//        if(this.service.read(String.valueOf(student)).isPresent()){
//            this.service.update(student);+
//        }else{
//            throw new NullPointerException("Student not found");
//        }
//    }
//
////    @Test
////    public void testReadAll(){
////        assertNotNull(this.service.readAll());
////    }
//
//    @AfterEach
//    void tearDown() {
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
//    }

//

}
