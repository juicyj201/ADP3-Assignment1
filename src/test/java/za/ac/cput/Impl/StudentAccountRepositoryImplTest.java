package za.ac.cput.Impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Domain.Factory.StudentAccountFactory;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentRepository Test
 * 05 April 2021
 *
 */

public class StudentAccountRepositoryImplTest {

    public static StudentAccountRepositoryImpl repository = StudentAccountRepositoryImpl.getRepository();
    public static StudentAccount studentAccount = StudentAccountFactory
                .createStudentAccount("001", "219113149","12.00","12.00");


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create(){
    StudentAccount created = repository.create("001", studentAccount);
    assertEquals(studentAccount.getStudAccountNumber(), created.getStudentID());
    System.out.println("Student Account created: " + created);
    }

    @Test
    void read(){
    StudentAccount read = repository.read(studentAccount.getStudAccountNumber());
    assertNotNull(read);
    }

    @Test
    void update(){
    }

    @Test
    void delete(){
 }

   @Test
   void getAll(){
   System.out.println(repository.getAll());
   }

    @Test
    public void test(){
        StudentAccountRepositoryImpl repository = StudentAccountRepositoryImpl.getRepository();
    }

    @AfterAll
    public static void tearDownClass() {
    }
}
