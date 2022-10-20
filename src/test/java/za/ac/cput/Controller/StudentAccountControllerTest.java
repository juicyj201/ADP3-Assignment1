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
    private StudentAccount studentAccounta ;
    @LocalServerPort
    private int baseport;
    private String localhost;
    @Autowired
    private TestRestTemplate restTemplate;
    @BeforeEach
    public void setUp(){
        assertNotNull(studentAccountController);
        this.studentAccounta = StudentAccountFactory.createStudentAccount(11111, "219113149", "45.00", "40.00");
        this.localhost = "http://localhost:"+this.baseport+"/studentAccount/";
    }

    @Test
    public void testSave(){
        String url = localhost + "save/";
        System.out.println("Student Account to save: " + this.studentAccounta);
        ResponseEntity<StudentAccount>response = this.restTemplate.postForEntity(url, this.studentAccounta,StudentAccount.class);
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response),
                ()-> assertNotNull(response.getBody())
        );
        System.out.printf("Student Account saved: " + response.getBody());

    }

    @Test
    public void testRead(){

        String url = localhost + "read/" + this.studentAccounta.getStudAccountNumber();
        System.out.println(url);
        ResponseEntity<StudentAccount> response = this.restTemplate.getForEntity(url, StudentAccount.class);;
        System.out.println(response);
        assertAll(
                ()-> assertNotNull(response.getBody())
        );
        System.out.printf("Student Account found: " + response.getBody());
    }


    @Test
    public void testDelete(){
        String url = localhost + "delete/" + this.studentAccounta.getStudAccountNumber();
        this.restTemplate.delete(url);
        System.out.println("Student Account deleted: " + this.studentAccounta.getStudAccountNumber()+"\n"+url);
    }

    @Test
    public void testUpdate(){
        String url = localhost + "update/" + this.studentAccounta.getStudAccountNumber();
        System.out.println(url);
        ResponseEntity<StudentAccount> response = this.restTemplate.getForEntity(url, StudentAccount.class);;
        System.out.println(response);
        assertAll(
                ()-> assertEquals(HttpStatus.OK, response.getStatusCode()),
                ()-> assertNotNull(response),
                ()-> assertNotNull(response.getBody())
        );
        System.out.printf("Student Account updated: " + response.getBody());

    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

}
