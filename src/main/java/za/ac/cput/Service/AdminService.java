package za.ac.cput.Service;

import za.ac.cput.Domain.Entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService extends IService<Admin, String>{
    public Admin save(Admin admin);
    public Optional<Admin> read(Admin admin);
    public void delete(Admin admin);
    public List<Admin> readAll();
}
