package za.ac.cput.Impl;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Repository
 * 05 April 2021
 *
 */

import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentRepositoryImpl implements IRepository<Student> {
private static StudentRepositoryImpl repository = null;
private Set<Student> studentDB = null;

public StudentRepositoryImpl(){
studentDB = new HashSet<Student>();
}

public static StudentRepositoryImpl getRepository(){
    if (repository == null){
        repository = new StudentRepositoryImpl();
    }
    return repository;
}


    @Override
    public Student create(String id, Student object)
    {
        return null;
    }

    @Override
    public Student read(String id)
    {
        return null;
    }

    @Override
    public void update(String id, Student object) {

    }

    @Override
    public void delete(String id, Student object) {

    }
}