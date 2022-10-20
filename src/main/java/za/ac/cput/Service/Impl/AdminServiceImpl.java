package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.AdminRepository;

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
    public Optional<Admin> read(String ID) {
        return Optional.empty();
    }

    @Override
    public Optional<Admin> read(Long adminID) {
        if(adminID != 0) {
            System.out.println("Admin found: ");
            Optional<Admin> readAdmin = repo.findById(adminID);
            return readAdmin;
        }else{
            System.out.println("Error: Admin not found.");
            return null;
        }
    }

    @Override
    public Admin readByID(Long adminID) {
        if(adminID != 0) {
            System.out.println("Admin found: ");
            Admin readAdmin = repo.findById(adminID).get();
            return readAdmin;
        }else{
            System.out.println("Error: Admin not found.");
            return null;
        }
    }

    @Override
    public List<Admin> readAll() {
        if(repo.count() != 0) {
            List<Admin> aList = (List<Admin>) repo.findAll();
            System.out.println("Admin list is found");
            return aList;
        }else{
            System.out.println("Admin list not found");
            return null;
        }
    }

    @Override
    public Admin update(Admin admin) {
        if(Collections.emptyList() != repo) {
            List<Admin> aList = (List<Admin>) repo.findAll();
            Admin adminUpdate = aList.stream().findAny().get();
            if(adminUpdate.getAdminID() == admin.getAdminID()){
                adminUpdate.setAdminFullName(admin.getAdminFirstName(), admin.getAdminSurname());
                adminUpdate.setAdminType(admin.getAdminType());
                repo.save(adminUpdate);
                System.out.println("Admin updated.");
                //side note - not necessary to delete the original value in the db,
                //since using put will update the value automatically
            }
            return adminUpdate;
        }else{
            System.out.println("Error: Admin not found.");
            return null;
        }
    }

    @Override
    public void delete(Admin admin) {
        if(!admin.equals(null)) {
            repo.delete(admin);
            System.out.println("Admin deleted.");
        }else{
            System.out.println("Error: Admin not found.");
        }
    }


}
