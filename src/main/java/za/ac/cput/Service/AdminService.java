package za.ac.cput.Service;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The admin service interface
 */

public interface AdminService extends IService<Admin, String> {
    public Admin save(Admin admin);
    public Optional<Admin> read(Admin admin);
    public List<Admin> readAll();
    public Admin update(Admin admin);
    public void delete(Admin admin);
}
