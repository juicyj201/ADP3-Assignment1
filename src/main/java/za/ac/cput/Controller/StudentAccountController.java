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

import java.util.List;

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
    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentAccountController(StudentAccountService studentAccountService){
        this.studentAccountService = studentAccountService;
    }

    @PostMapping("save")
    public ResponseEntity<StudentAccount> save(StudentAccount studentAccount) {
        StudentAccount studentAccounts = studentAccountService.save(studentAccount);
        return ResponseEntity.ok(studentAccounts);
    }

    @GetMapping("read")
    public ResponseEntity<StudentAccount> read(StudentAccount studentAccount){
        StudentAccount studentAccounts  = studentAccountService.read(studentAccount).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(studentAccounts);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(StudentAccount studentAccount){
        log.info("Delete student: {}", studentAccount);
        this.delete(studentAccount);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("update")
    public ResponseEntity<StudentAccount> update(StudentAccount studentAccount){
        StudentAccount studentAccounts = studentAccountService.update(studentAccount);
        return ResponseEntity.ok(studentAccounts);
    }

    @GetMapping("readAll")
    public ResponseEntity<List<StudentAccount>> readAll(){
        List<StudentAccount>studentAccounts = this.studentAccountService.readAll();
        return ResponseEntity.ok(studentAccounts);
    }





}
