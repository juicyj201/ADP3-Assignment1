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
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.Domain.Entity.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, String> {
//    public Student save(Student student);
//    public Optional<Student> read(String id);
//    public List<Student> readAll();
//    public Student update(Student student);
//    public void delete(String id);
}
