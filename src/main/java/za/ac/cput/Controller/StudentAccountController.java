package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Service.Impl.StudentAccountService;
import za.ac.cput.Service.Impl.StudentAccountServiceImpl;
import java.util.Optional;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Controller
 *
 */

@RestController
@RequestMapping("/studentAccount")
public class StudentAccountController {

    private final StudentAccountService studentAccountService;
    private final static Logger log = LoggerFactory.getLogger(StudentAccountController.class);

    @Autowired
    public StudentAccountController(StudentAccountServiceImpl studentAccountService){
        this.studentAccountService = studentAccountService;
    }

    @PostMapping
    public ResponseEntity<StudentAccount> save(@RequestBody StudentAccount studentAccount) {
            log.info("Saving Account Student: {}", studentAccount);
            StudentAccount saveStudentAccount = studentAccountService.save(studentAccount);
            log.info("Student Account Saved: {}", studentAccount);
            return ResponseEntity.ok(saveStudentAccount);
    }

    @GetMapping
    public Optional<StudentAccount> read(StudentAccount studentAccount){
        log.info("Locating student: {}", studentAccount);
        return Optional.ofNullable(this.studentAccountService.read(studentAccount).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student Account does not exist")));

    }

    @PutMapping
    public StudentAccount update(StudentAccount studentAccount){
        log.info("Updating student: {}", studentAccount);
        this.studentAccountService.update(studentAccount);
        log.info("Student Updated: {}", studentAccount);
        return studentAccountService.update(studentAccount);
    }

    @DeleteMapping
    public void delete(StudentAccount studentAccount){
        log.info("Deleting student: {}", studentAccount);
        this.studentAccountService.delete(studentAccount);
        log.info("Student Deleted: {}", studentAccount);
    }


//    @GetMapping("readAll")
//    public ResponseEntity<List<StudentAccount>> readAll(){
//        List<StudentAccount> studentAccounts = this.studentAccountService.readAll();
//        return ResponseEntity.ok(studentAccounts);
//    }





}
