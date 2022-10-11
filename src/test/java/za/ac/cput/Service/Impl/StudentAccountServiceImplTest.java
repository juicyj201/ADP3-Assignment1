package za.ac.cput.Service.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Repository.StudentAccountRepository;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Service Implementation Test
 *
 */

public class StudentAccountServiceImplTest {
    private static StudentAccountRepository studentAccountRepository;
    private List<za.ac.cput.Domain.Entity.StudentAccount> studentAccountList;
    private StudentAccountServiceImpl studentAccountService;
    private za.ac.cput.Domain.Entity.StudentAccount studentAccount;

    @BeforeEach
    void setUp() {
    }

    @Test
    void save() {
        StudentAccount saved = this.studentAccountService.save(this.studentAccount);
        assertNotNull(saved);
        System.out.println("Student Account has been saved");
    }

    @Test
    void read() {
        StudentAccount saved = this.studentAccountService.save(this.studentAccount);
        Optional<StudentAccount> read = this.studentAccountService.read(this.studentAccount.getStudAccountNumber());
        System.out.println(saved);
    }

    @Test
    void delete() {
        StudentAccount saved = this.studentAccountService.save(this.studentAccount);
        this.studentAccountService.delete(this.studentAccount);
        assertEquals(0, studentAccountList.size());
        System.out.println("Student Account was deleted");
    }

//    @Test
//    void readAll() {
//        StudentAccount saved = this.studentAccountService.save(this.studentAccount);
//        List<StudentAccount> studentList = studentAccountService.readAll();
//        assertEquals(0, studentAccountList.size());
//        System.out.println(studentAccountList);
//    }

    @AfterEach
    void tearDown() {
    }


}