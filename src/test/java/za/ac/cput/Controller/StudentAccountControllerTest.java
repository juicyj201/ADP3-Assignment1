package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Factory.StudentAccountFactory;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Controller Test
 *
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentAccountControllerTest {
    @Autowired
    private StudentAccountController studentAccountController;
    private StudentAccount studentAccounta = StudentAccountFactory.createStudentAccount(12121212L, "219113149", "24.00", "20.00");

    @LocalServerPort
    private int baseport;
    private String baseURL;
    @Autowired
    private TestRestTemplate restTemplate;
    @BeforeEach
    public void setUp(){
        assertNotNull(studentAccountController);
        this.studentAccounta = StudentAccountFactory.createStudentAccount(11111, "219113149", "45.00", "40.00");
        this.baseURL = "http://localhost:"+this.baseport+"/studentAccount/";
        System.out.println(studentAccounta);
    }

    @Test
    public void testSave(){
        String url = baseURL + "save/";
        System.out.println(url);
        try {
            Assertions.assertNotNull(studentAccountController.save(studentAccounta));
        }catch(NullPointerException npe) {
            npe.getMessage();
            npe.getStackTrace();
        }
        System.out.println(this.studentAccounta.getStudentID()+ ": Has been saved");}


    @Test
    public void testRead(){

        try {
            Assertions.assertNotNull(studentAccountController.read(studentAccounta.getStudAccountNumber()));
        }catch(NullPointerException nullPointerException){
            nullPointerException.getMessage();
            nullPointerException.getStackTrace();
        }
        System.out.println("Student Account Found: " + studentAccounta);
    }


    @Test
    public void testDelete(){
        String url = baseURL + "delete/" + this.studentAccounta.getStudAccountNumber();
        this.restTemplate.delete(url);
        System.out.println("Student Account deleted: " + this.studentAccounta.getStudAccountNumber()+"\n"+url);
    }

    @Test
    public void testUpdate(){
        String url = baseURL + "update/" + this.studentAccounta.getStudentID();
        System.out.println(url);
        this.restTemplate.put(url, studentAccounta);
        System.out.println("Student Account updated: " + this.studentAccounta.getStudAccountNumber()+"\n"+url);


    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

}
