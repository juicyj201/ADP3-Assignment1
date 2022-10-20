package za.ac.cput.Repository;
/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Repository
 *
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Domain.Entity.StudentAccount;
import java.util.List;
import java.util.Optional;

public interface StudentAccountRepository extends JpaRepository<StudentAccount, String> {
//    public StudentAccount save(StudentAccount student);
//    public Optional<StudentAccount> read(String id);
//    public List<StudentAccount> readAll();
//    public StudentAccount update(Student student);
//    public void delete(String id);
}
