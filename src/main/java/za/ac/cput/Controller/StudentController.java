package za.ac.cput.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Service.Impl.StudentService;
import za.ac.cput.Service.Impl.StudentServiceImpl;
import java.util.Optional;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Controller
 *
 */


@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final static Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    public StudentController(StudentServiceImpl studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        log.info("Saving Account Student: {}", student);
        Student saveStudent = studentService.save(student);
        log.info("Student Account Saved: {}", student);
        return ResponseEntity.ok(saveStudent);
    }

    @GetMapping
    public Optional<Student> read(Student student){
        log.info("Locating student: {}", student);
        return Optional.ofNullable(this.studentService.read(String.valueOf(student)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student does not exist")));

    }

    @PutMapping
    public Student update(Student student){
        log.info("Updating student: {}", student);
        this.studentService.update(student);
        log.info("Student Updated: {}", student);
        return studentService.update(student);
    }

    @DeleteMapping
    public void delete(Student student){
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
