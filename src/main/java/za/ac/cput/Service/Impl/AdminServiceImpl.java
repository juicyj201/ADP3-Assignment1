package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.Service.AdminService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repo;

    @Autowired
    public AdminServiceImpl(AdminRepository repo){
        this.repo = repo;
    }

    @Override
    public Admin save(Admin admin) {
        if(!admin.equals(null)) {
            repo.save(admin);
            System.out.println("Admin saved: ");
            return admin;
        }else{
            System.out.println("Error: Admin not found");
            return null;
        }
    }

    @Override
    public Optional<Admin> read(Admin admin) {
        if(!admin.equals(null)) {
            System.out.println("Admin found: ");
            return repo.findById(admin.getAdminID());
        }else{
            System.out.println("Error: Admin not found.");
            return null;
        }
    }

    @Override
    public void delete(Admin admin) {
        if(!admin.equals(null)) {
            repo.delete(admin);
        }else{
            System.out.println("Error: Admin not found.");
        }
    }

    @Override
    public List<Admin> readAll() {
        if(Collections.emptyList() != repo) {
            return repo.findAll();
        }else{
            System.out.println("Error: Admin not found.");
            return null;
        }
    }
}
