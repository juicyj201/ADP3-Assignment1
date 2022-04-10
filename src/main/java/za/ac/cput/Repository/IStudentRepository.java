package za.ac.cput.Repository;

import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Domain.Entity.StudentAccount;

import java.util.HashMap;

public interface IStudentRepository extends IRepository<Student>{
    public HashMap<String, Student> getAll();

    @Override
    public Student create(String id, Student object);

    @Override
    public Student read(String id);

    @Override
    public void update(String id, Student object);

    @Override
    public boolean delete(String id);
}

