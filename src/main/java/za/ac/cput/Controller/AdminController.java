package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.Service.AdminService;
import za.ac.cput.Service.Impl.AdminServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private AdminService service;

    @Autowired
    public AdminController(AdminServiceImpl adminService){
        this.service = adminService;
    }

    @PostMapping
    private Admin saveAdmin(@RequestBody Admin admin){
        return service.save(admin);
    }

    @GetMapping
    public List<Admin> getAllAdmin() {
        return service.readAll();
    }

}
