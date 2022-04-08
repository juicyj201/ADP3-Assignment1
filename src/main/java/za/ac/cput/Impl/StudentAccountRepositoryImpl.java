package za.ac.cput.Impl;
/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Repository
 * 05 April 2021
 *
 */

import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Repository.IRepository;

import java.util.HashSet;
import java.util.Set;

public class StudentAccountRepositoryImpl implements IRepository<StudentAccount> {
    private static StudentAccountRepositoryImpl repository = null;
    private Set<StudentAccount> studentDB = null;

    private StudentAccountRepositoryImpl(){
        studentDB = new HashSet<StudentAccount>();
    }

    public static StudentAccountRepositoryImpl getRepository(){
        if (repository == null){
            repository = new StudentAccountRepositoryImpl();
        }
        return repository;
    }

    @Override
    public StudentAccount create(String id, StudentAccount object) {
        return null;
    }

    @Override
    public StudentAccount read(String id) {
        return null;
    }

    @Override
    public void update(String id, StudentAccount object) {

    }

    @Override
    public void delete(String id, StudentAccount object) {

    }
}
