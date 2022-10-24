package za.ac.cput.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Service.Impl.StudentService;
import za.ac.cput.Service.Impl.StudentServiceImpl;

import javax.validation.Valid;
import java.util.Optional;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Controller
 *
 */


@RestController
@RequestMapping("/student/")
public class StudentController {
    private StudentService studentService;
    private final static Logger log = LoggerFactory.getLogger(StudentController.class);
    public RestOperations restTemplate;

    @Autowired
    public StudentController(StudentServiceImpl studentService){
        this.studentService = studentService;
    }

    @PostMapping("save/")
    public Student save(@RequestBody @Valid Student student) {
        log.info("Student Account Saved: {}", student);
        return studentService.save(student);
    }

    @GetMapping("read/{studentID}")
    public Optional<Student> read( @PathVariable Long studentID){
        log.info("Locating student: {}", studentID);
        return studentService.read(studentID);

    }

    @PutMapping("update/")
    public Student update(@RequestBody Student student){
        log.info("Updating student: {}", student);
        return studentService.save(student);
    }

    @DeleteMapping("delete/")
    public void delete(@RequestBody Student student){
        log.info("Deleting student: {}", student);
        this.studentService.delete(student);
        log.info("Student Deleted: {}", student);
    }


//    @GetMapping("readAll")
//    public ResponseEntity<List<Student>> readAll(){
//        List<Student> student = this.studentService.readAll();
//        return ResponseEntity.ok(student);
//    }
}
