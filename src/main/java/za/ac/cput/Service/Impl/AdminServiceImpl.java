package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.Service.AdminService;
import za.ac.cput.Service.PaymentService;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService {
    private AdminRepository repo;
    private static AdminService service;

    public static AdminService getService(){
        if(service == null){
            service = new AdminServiceImpl();
        }

        return service;
    }

    @Override
    public Admin save(Admin admin) {
        return null;
    }

    @Override
    public Optional<Admin> read(Admin admin) {
        return Optional.empty();
    }

    @Override
    public void delete(Admin admin) {

    }

    @Override
    public List<Admin> readAll() {
        return null;
    }
}
