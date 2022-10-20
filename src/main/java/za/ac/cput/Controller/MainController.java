package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.Impl.AdminServiceImpl;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private EmployeeServiceImpl serviceEmployee;
    @Autowired
    private AdminServiceImpl serviceAdmin;
    protected final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/main")
    public ModelAndView login(@ModelAttribute("username") String username, @ModelAttribute("password") String password) {
        ModelAndView model;
        System.out.println("Username: "+username);
        System.out.println("Password: "+password);

        Employee tempE = serviceEmployee.readByID(Long.parseLong(username));
        Admin tempA = serviceAdmin.readByID(Long.parseLong(username));

        if (!tempE.equals(null)) {
            if (!tempE.getEmployeeNum().equals(null) && !tempE.getPassword().equals(null)) {
                model = new ModelAndView();
                model.setViewName("view-student-accounts.html");
               //model.addObject("mainmessage", "Employee " + tempE.getEmpFirstName() + ", successfully logged in.");
                return model;
            }
        }
        else if (!tempA.equals(null)) {
            if (tempA.getAdminID() != 0 && !tempA.getAdminType().equals(null)) {
                model = new ModelAndView();
                model.setViewName("view-admin-accounts.html");
                //model.addObject("mainmessage", "Admin " + tempA.getAdminFirstName() + ", successfully logged in.");
                return model;
            }
        } else {
            model = new ModelAndView();
            model.setViewName("Error.html");
            model.addObject("errormessage", "an error has occurred");
            return model;
        }

        return null;
    }
}
