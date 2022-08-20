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
import java.util.List;

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
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping("save")
    public ResponseEntity<Student> save(Student student) {
        Student students = studentService.save(student);
        return ResponseEntity.ok(students);
    }

    @GetMapping("read")
    public ResponseEntity<Student> read(Student student){
        Student students  = studentService.read(student).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(students);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> delete(Student student){
        log.info("Delete student: {}", student);
        this.delete(student);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("update")
    public ResponseEntity<Student> update(Student student){
        Student students = studentService.update(student);
        return ResponseEntity.ok(students);
    }

    @GetMapping("readAll")
    public ResponseEntity<List<Student>> readAll(){
        List<Student>students = this.studentService.readAll();
        return ResponseEntity.ok(students);
    }
}
