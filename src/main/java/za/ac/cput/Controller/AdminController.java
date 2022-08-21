package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Service.Impl.AdminService;
import za.ac.cput.Service.Impl.AdminServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * Joshua Julies
 * 220102473
 * The admin controller
 */

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService service;
    protected final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    public AdminController(AdminServiceImpl adminService){
        this.service = adminService;
        //side note - controller uses dependency injection for the service object,
        //similarly in the service implementations for the repository objects.
    }

    @PostMapping
    public Admin saveAdmin(@RequestBody Admin admin){
        logger.info("Request has initiated...");
        Admin savedAdmin = service.save(admin);
        logger.info("Admin has been saved to the database");
        return savedAdmin;
    }

    @GetMapping
    public Optional<Admin> getAdminByID(Admin admin){
        logger.info("Service has begun reading admin requested...");
        return service.read(admin);
    }

//    @GetMapping
//    public List<Admin> getAllAdmin() {
//        logger.info("Service has begun reading the admin list requested...");
//        return service.readAll();
//    }

    @PutMapping
    public Admin updateAdmin(Admin admin){
        logger.info("Service has begun updating the admin request...");
        Admin updatedAdmin = service.update(admin);
        logger.info("Admin "+updatedAdmin.getAdminFirstName()+", has been updated.");
        return updatedAdmin;
    }

    @DeleteMapping
    public void deleteAdmin(Admin admin){
        logger.info("Service has begun deletion of admin...");
        service.delete(admin);
        logger.info("Admin "+admin.getAdminFirstName()+", has been deleted.");
    }

}
