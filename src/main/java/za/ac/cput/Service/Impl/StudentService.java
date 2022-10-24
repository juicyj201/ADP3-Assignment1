package za.ac.cput.Service.Impl;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Service
 *
 *
 */

import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Service.IService;
import java.util.List;
import java.util.Optional;

public interface StudentService
{
    Student save(Student student);
    Optional<Student> read(Long studentID);
    void delete(Student student);
    Student update(Student student);
}
