package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Factory.StudentAccountFactory;
import za.ac.cput.Service.Impl.StudentAccountService;
import za.ac.cput.Service.Impl.StudentAccountServiceImpl;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Controller Test
 *
 */

public class StudentAccountControllerTest {
    private StudentAccount studentAccount;
    private StudentAccountService service = StudentAccountServiceImpl.getService();
    private String localhost;
    @Autowired
    private StudentAccountController studentAccountController;

    @BeforeEach
    void setUp() {
        assertNotNull(studentAccountController);
        this.studentAccount = StudentAccountFactory.createStudentAccount("0111", "219113140", "24.00", "12.00");
    }

    @Test
    public void testSave(){
        assertNotNull(this.service.save(studentAccount));
        String url = localhost + "/save";
        System.out.println(url);
        ResponseEntity<StudentAccount> response = this.studentAccountController.save(studentAccount);
        System.out.println(response);
        assertAll(()-> assertEquals(HttpStatus.OK, response.getStatusCode()), ()-> assertNotNull(response.getBody())
        );
    }

    @Test
    public void testRead(){
        assertNotNull(this.service.read(studentAccount));
        StudentAccount saved = this.service.save(this.studentAccount);
        Optional<StudentAccount> read = this.service.read(this.studentAccount);
        assertAll(() -> Assertions.assertTrue(read.isPresent()), () -> Assertions.assertSame(saved, read.get()));
        System.out.println(saved);
    }

    @Test
    public void testDelete(){
        if(this.service.read(studentAccount) != null){
            this.service.delete(studentAccount);
        }else{
            throw new NullPointerException("Student Account not found");
        }
    }

    @Test
    public void testUpdate(){
        if(this.service.read(studentAccount) != null){
            this.service.update(studentAccount);
        }else{
            throw new NullPointerException("Student Account not found");
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
