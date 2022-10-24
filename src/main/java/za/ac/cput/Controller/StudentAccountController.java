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

import javax.validation.Valid;
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

    @PostMapping("save/")
    public StudentAccount save(@RequestBody @Valid StudentAccount studentAccount) {
            log.info("Saving Student account: {}", studentAccount);
            return studentAccountService.save(studentAccount);
    }

    @GetMapping("read/{studAccountNumber}")
    public Optional<StudentAccount> read(@PathVariable long studAccountNumber){
        log.info("Locating student account: {}", studAccountNumber);
        return studentAccountService.read(studAccountNumber);

    }

    @PutMapping("update/")
    public StudentAccount update(@RequestBody StudentAccount studentAccount){
        log.info("Updating student account: {}", studentAccount);
        return studentAccountService.save(studentAccount);
    }

    @DeleteMapping("delete/")
    public void delete(@RequestBody StudentAccount studentAccount){
        log.info("Deleting student account: {}", studentAccount);
        this.studentAccountService.delete(studentAccount);
        log.info("Student account deleted: {}", studentAccount);
    }


//    @GetMapping("readAll")
//    public ResponseEntity<List<StudentAccount>> readAll(){
//        List<StudentAccount> studentAccounts = this.studentAccountService.readAll();
//        return ResponseEntity.ok(studentAccounts);
//    }





}
