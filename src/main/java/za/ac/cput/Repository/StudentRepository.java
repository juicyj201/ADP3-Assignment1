package za.ac.cput.Repository;
/**
 *
 * Keziah Robinson
 * 219113149
 * Student Repository
 *
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student save(Student student);
    Optional<Student> read(String id);
    List<Student> readAll();
    public Student update(Student student);
    void delete(String id);
}
