package za.ac.cput.Service.Impl;

/**
 *
 * Keziah Robinson
 * 219113149
 * StudentAccount Service
 *
 *
 */

import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface StudentAccountService extends IService<StudentAccount, String> {
    public StudentAccount save(StudentAccount student);
    public Optional<StudentAccount> read(String studAccountNumber);
    public void delete(StudentAccount studentAccount);
    public StudentAccount update(StudentAccount studentAccount);
    public List<StudentAccount> readAll();
}
