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

public class StudentAccountRepositoryImpl implements IRepository<StudentAccount> {
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
    public void delete(String id) {

    }
}
