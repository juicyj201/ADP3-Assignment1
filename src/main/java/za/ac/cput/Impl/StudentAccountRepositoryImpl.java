package za.ac.cput.Impl;
/**
 *
 * Keziah Robinson
 * 219113149
 * Student Account Repository
 * 05 April 2021
 *
 */

import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Repository.IRepository;

import java.util.HashMap;
import java.util.HashSet;

public class StudentAccountRepositoryImpl implements IRepository<StudentAccount> {
    private static StudentAccountRepositoryImpl repository = null;
    private HashSet<StudentAccount> studentAccountSetDB = null;
    private HashMap<String, StudentAccount>studentAccountMapDB = null;


    private StudentAccountRepositoryImpl(){
        studentAccountMapDB = new HashMap<String, StudentAccount>();
    }

    public static StudentAccountRepositoryImpl getRepository(){
        if (repository == null){
            repository = new StudentAccountRepositoryImpl();
            return repository;
        }
        else {
            return null;
        }
    }

    @Override
    public StudentAccount create(String id, StudentAccount object) {
        studentAccountMapDB.put(id, object);
        studentAccountMapDB.put(id, object);
        if(studentAccountMapDB.containsValue(id)){
            return null;
        }
        else {
            return object;
        }
    }

    @Override
    public StudentAccount read(String StudAccountNumber) {
        for (StudentAccount studentAccount : studentAccountSetDB)
            if (studentAccount.getStudAccountNumber().equals(StudAccountNumber))
                return studentAccount;
        return null;
    }


    @Override
    public void update(String id, StudentAccount object) {
        StudentAccount oldStudentAccount = read(String.valueOf(id));
        if (oldStudentAccount != null){
            studentAccountMapDB.remove(oldStudentAccount);
        }


    }

    @Override
    public void delete(String id) {
        final StudentAccount removestudentAccount = read(id);
        if(removestudentAccount == null){
            studentAccountMapDB.remove(id);}


    }


    public HashMap<String, StudentAccount> getAll() {
        return studentAccountMapDB;
    }
}

