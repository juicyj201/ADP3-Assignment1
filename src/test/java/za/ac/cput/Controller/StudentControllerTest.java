package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Factory.StudentFactory;

import java.io.IOException;

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
    private static final String SECURITY_USERNAME = "quandale";
    private static final String SECURITY_PASSWORD = "dingle";
    @Autowired
    private StudentController studentController;
    private Student studenta = StudentFactory.createStudent(219113140L, "Peter", "Griffin", "Male", "47", "Peanuts");;

    @LocalServerPort
    private int port;
    private  String baseURL = "http://localhost:"+this.port+"/student/";
    @Autowired
    private TestRestTemplate restTemplate;

    @BeforeEach
    public void setUp(){
        assertNotNull(studentController);
        this.studenta = StudentFactory.createStudent(219113141L, "Pieter", "Griffin", "Male", "47", "Peanuts");

        this.baseURL = "http://localhost:"+this.port+"/student/";
        System.out.println(studenta);
    }

    @Test
    public void testSave(){
        String url = baseURL + "save/";
        System.out.println(url);
        try {
            Assertions.assertNotNull(studentController.save(studenta));
        }catch(NullPointerException npe) {
            npe.getMessage();
            npe.getStackTrace();
        }
        System.out.println(this.studenta.getStudentID()+ ": Has been saved");}



    @Test
    public void testRead(){


        try {
            Assertions.assertNotNull(studentController.read(studenta.getStudentID()));
        }catch(NullPointerException npe){
            npe.getMessage();
            npe.getStackTrace();
        }catch(Exception e){
            e.getMessage();
        }
        System.out.println("Student Found: " + studenta);

    }


    @Test
    public void testDelete(){
        String url = baseURL + "delete/" + this.studenta.getStudentID();
        this.restTemplate.delete(url);
        System.out.println("Student deleted: " + this.studenta.getStudentID()+"\n"+url);
    }

    @Test
    public void testUpdate(){
        String url = baseURL + "update/" + this.studenta.getStudentID();
        System.out.println(url);
        this.restTemplate.put(url, studenta);
        System.out.println("Student updated: " + this.studenta.getStudentID()+"\n"+url);

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
