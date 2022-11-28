package za.ac.cput.Service.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The admin service interface
 */

public interface AdminService extends IService<Admin, Long> {
    public Admin save(Admin admin);
    public Optional<Admin> read(Long adminID);
    public Admin readByID(Long adminID);
    public List<Admin> readAll();
    public Admin update(Admin admin);
    public void delete(Admin admin);
}
