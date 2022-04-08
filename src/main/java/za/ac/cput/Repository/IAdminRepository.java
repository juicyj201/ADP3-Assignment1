package za.ac.cput.Repository;

import za.ac.cput.Domain.Entity.Admin;

import java.util.Map;
import java.util.Set;

/**
 * Joshua Julies
 * 220102473
 * The admin repository interface
 */

public interface IAdminRepository extends IRepository<Admin>{
    public Map<String, Admin> getAll();

    @Override
    public Admin create(String id, Admin object);

    @Override
    public Admin read(String id);

    @Override
    public void update(String id, Admin object);

    @Override
    public void delete(String id, Admin object);
}
