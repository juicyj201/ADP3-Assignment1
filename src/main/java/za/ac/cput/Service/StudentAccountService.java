package za.ac.cput.Service;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Service
 *
 *
 */

import za.ac.cput.Domain.Entity.StudentAccount;
import java.util.List;
import java.util.Optional;

public interface StudentAccountService extends IService<StudentAccount, String>{
    public StudentAccount save(StudentAccount student);
    public Optional<StudentAccount> read(StudentAccount studentAccount);
    public void delete(StudentAccount studentAccount);
    public StudentAccount update(StudentAccount studentAccount);
    public List<StudentAccount> readAll();
}
