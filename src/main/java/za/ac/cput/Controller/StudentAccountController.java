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

import java.util.List;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Controller
 *
 */

@RestController
//@RequestMapping("/studentAccount")
public class StudentAccountController {
    @Autowired
    private StudentAccountService studentAccountService;
    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

//    @Autowired
//    public StudentAccountController(StudentAccountServiceImpl studentAccountService){
//        this.studentAccountService = studentAccountService;
//    }

    @PostMapping("/studentAccount")
    public StudentAccount save(StudentAccount studentAccount) {
        StudentAccount studentAccounts = studentAccountService.save(studentAccount);
        return studentAccounts;
    }

    @GetMapping("/studentAccount/{studAccountNumber}")
    public StudentAccount read(@PathVariable String studAccountNumber){
        StudentAccount studentAccounts  = studentAccountService.read(studAccountNumber).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return studentAccounts;
    }

    @DeleteMapping("/studentAccount")
    public void delete(StudentAccount studentAccount){
        log.info("Delete student: {}", studentAccount);
        this.delete(studentAccount);
    }

    @PutMapping("/studentAccount")
    public StudentAccount update(StudentAccount studentAccount){
        StudentAccount studentAccounts = studentAccountService.update(studentAccount);
        return studentAccounts;
    }

    @GetMapping("/studentAccount")
    public ResponseEntity<List<StudentAccount>> readAll(){
        List<StudentAccount>studentAccounts = this.studentAccountService.readAll();
        return ResponseEntity.ok(studentAccounts);
    }
}
