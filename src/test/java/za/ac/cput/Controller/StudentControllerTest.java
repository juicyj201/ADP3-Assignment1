package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Factory.StudentFactory;

import static org.junit.jupiter.api.Assertions.*;


/**
 *
 * Keziah Robinson
 * 219113149
 * Student  Controller Test
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentControllerTest {
    @Autowired
    private StudentController studentController;
    private Student studenta = StudentFactory.createStudent(219113140, "Peter", "Griffin", "Male", "47", "Peanuts");;
    //just changed the ID bruh
    private Student studentupdated = StudentFactory.createStudent(219113141, "Peter", "Griffin", "Male", "47", "Peanuts");;
    @LocalServerPort
    private int port;
    private  String localhost = "http://localhost:"+this.port+"/student/";
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
        ResponseEntity<Student>response = this.restTemplate.postForEntity(url, this.studenta, Student.class);
        if(!response.equals(null)) System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response)
//                ()-> assertNotNull(response.getBody())
        );
       // System.out.printf("Student saved: " + response.getBody());
        System.out.println("Student saved: "+response );
    }

    @Test
    public void testRead(){

        String url = localhost + "read/" + this.studenta.getStudentID();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        if(!response.equals(null)) System.out.println(response);

        assertAll(
                ()-> assertNotNull(response)
        );
        System.out.printf("Student found: " + response);
    }


    @Test
    public void testDelete(){
        String url = localhost + "delete/" + this.studenta.getStudentID();
        this.restTemplate.delete(url);
        System.out.println("Student deleted: " + this.studenta.getStudentID()+"\n"+url);
    }

    @Test
    public void testUpdate(){
        String url = localhost + "update/" + this.studenta.getStudentID();
        System.out.println(url);
        this.restTemplate.put(url, studentupdated);
        System.out.println("Student updated: " + this.studentupdated.getStudentID()+"\n"+url);

//        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class, studenta);
//        System.out.println(response);
//        assertAll(
//                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
//                ()-> assertNotNull(response)
////                ()-> assertNotNull(response.getBody())
//        );
//        System.out.printf("Student updated: " + response.getBody());

    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }



}
