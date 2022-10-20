package za.ac.cput.Service.Impl;
/**
 *
 * Keziah Robinson
 * 219113149
 * Student Service Implementation
 *
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
private final StudentRepository studentRepository;
@Autowired
public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    public Optional<Student> read(Long studentID) {
    return this.studentRepository.findById(studentID);
    }

    @Override
    public void delete(Student student) {
       this.studentRepository.delete(student);
    }

    @Override
    public Student update(Student student) {
        return this.studentRepository.save(student);
    }
}
