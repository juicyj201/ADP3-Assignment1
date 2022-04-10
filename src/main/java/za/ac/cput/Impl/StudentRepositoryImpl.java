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

import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Repository.IRepository;

import java.util.HashMap;
import java.util.HashSet;

public class StudentRepositoryImpl implements IRepository<Student> {
    private static StudentRepositoryImpl repository = null;
    private HashSet<Student> studentSetDB = null;
    private HashMap<String, Student> studentMapDB = null;

    public StudentRepositoryImpl(){
        studentMapDB = new HashMap<String, Student>();
    }

    public static StudentRepositoryImpl getRepository(){
        if (repository == null){
            repository = new StudentRepositoryImpl();
            return repository;
        }
        else {
            return null;
        }
    }


    @Override
    public Student create(String id, Student object) {
        studentMapDB.put(id, object);
        studentMapDB.put(id, object);
        if(studentMapDB.containsValue(id)){
            return null;
        }
        else {
            return object;
        }
    }

    @Override
    public Student read(String StudentID) {
        for (Student student : studentSetDB)
            if (student.getStudentID().equals(StudentID))
                return student;
        return null;
    }

    @Override
    public void update(String id, Student object) {
        Student oldStudent = read(String.valueOf(id));
        if (oldStudent != null){
            studentMapDB.remove(oldStudent);
        }
    }


    @Override
    public boolean delete(String id) {
        Student removeStudent = read(id);
        studentMapDB.remove(removeStudent);

return false;


    }

    public HashMap<String, Student> getAll() {
        return studentMapDB;
    }
}