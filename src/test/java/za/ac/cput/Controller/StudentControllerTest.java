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

        ResponseEntity<Student> response = this.restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, this.studenta, Student.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode())
//                ()-> assertNotNull(response.getBody())
        );



        System.out.println("Student to save: " + this.studenta);}
//        ResponseEntity<Student>response = this.restTemplate.postForEntity(url, this.studenta, Student.class);
//        if(response != null) System.out.println(response);
//        assertAll(
//                ()-> {
//                    assert response != null;
//                    assertEquals(HttpStatus.OK, response.getStatusCode());
//                },
//                ()-> assertNotNull(response)
//        );
//       // System.out.printf("Student saved: " + response.getBody());
//        System.out.println("Student saved: "+response );



    @Test
    public void testRead(){

        String url = baseURL + "read/" + this.studenta.getStudentID();
        System.out.println(url);
        ResponseEntity<Student> response = this.restTemplate.getForEntity(url, Student.class);
        if(response != null) System.out.println(response);

        assertAll(
                ()-> assertNotNull(response)
        );
        System.out.printf("Student found: " + response);
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
