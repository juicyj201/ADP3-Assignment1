package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Repository.AdminRepository;
import za.ac.cput.Service.AdminService;

import java.util.List;

@RestController
public class AdminController {
    @Autowired
    private AdminRepository repo;

    @PostMapping("/admin")
    private ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        Admin adminToSave = repo.save(admin);
        return ResponseEntity.ok(adminToSave);
    }

    @GetMapping("/admin")
    public List<Admin> getAllAdmin() {
        return repo.findAll();
    }
}
