package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
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
public class AdminController {
    @Autowired
    private AdminService service;
    protected final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @PostMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Admin saveAdmin(@RequestBody Admin admin){
        logger.info("Request has initiated...");
        Admin savedAdmin = service.save(admin);
        logger.info("Admin has been saved to the database");
        return savedAdmin;
    }

    @GetMapping("/admin/{adminID}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Optional<Admin> getAdminByID(@PathVariable Long adminID){
        logger.info("Service has begun reading admin requested...");
        return service.read(adminID);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public List<Admin> getAllAdmin() {
        logger.info("Service has begun reading the admin list requested...");
        return service.readAll();
    }

    @PutMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Admin updateAdmin(@RequestBody Admin admin){
        logger.info("Service has begun updating the admin request...");
        Admin updatedAdmin = service.update(admin);
        logger.info("Admin "+updatedAdmin.getAdminFirstName()+", has been updated.");
        return updatedAdmin;
    }

    @DeleteMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void deleteAdmin(Admin admin){
        logger.info("Service has begun deletion of admin...");
        service.delete(admin);
        logger.info("Admin "+admin.getAdminFirstName()+", has been deleted.");
    }

    /**
     * @getAdmin()
     *
     * This method will allow one or more admins' details to be displayed,
     * within the view admin accounts page. It's return type is ModelAndView
     * since it allows the passing of information directly to the web pages
     * through the controller, as is the MVC structure.
     *
     */
    @RequestMapping("/admin-accounts")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public ModelAndView getAdmin(){
        ModelAndView model = new ModelAndView();
        model.addObject("admins", (List<Admin>) service.readAll());
        model.setViewName("view-admin-accounts.html");
        logger.info("All admins have been loaded from the database successfully");

        return model;
    }
}
