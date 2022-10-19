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
    public ModelAndView login(@ModelAttribute Employee employee, Admin admin) {
        ModelAndView model;
        Optional<Employee> tempE = serviceEmployee.read(employee.getEmployeeNum());
        Optional<Admin> tempA = serviceAdmin.read(admin.getAdminID());

        System.out.println(tempE.get().getEmpFirstName());
        System.out.println(tempA.get().getAdminFirstName());

        //TODO - check that the employee password is working and that the username exists rather than just the employee password

        if (!tempE.equals(null)) {
            if (!tempE.get().getEmployeeNum().equals(null) && !tempE.get().getPassword().equals(null)) {
                model = new ModelAndView();
                model.setViewName("Main.html");
                model.addObject("mainmessage", "Employee " + employee.getEmpFirstName() + ", successfully logged in.");
                return model;
            }
        }
        else if (!tempA.equals(null)) {
            if (tempA.get().getAdminID() != 0 && !tempA.get().getAdminType().equals(null)) {
                model = new ModelAndView();
                model.setViewName("Main.html");
                model.addObject("mainmessage", "Admin " + admin.getAdminFirstName() + ", successfully logged in.");
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
