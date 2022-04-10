package za.ac.cput.Repository;

import za.ac.cput.Domain.Entity.StudentAccount;

import java.util.HashMap;

public interface IStudentAccountRepository extends IRepository<StudentAccount> {
    public HashMap<String, StudentAccount> getAll();

    @Override
    public StudentAccount create(String id, StudentAccount object);

    @Override
    public StudentAccount read(String id);

    @Override
    public void update(String id, StudentAccount object);

    @Override
    public boolean delete(String id);
}
