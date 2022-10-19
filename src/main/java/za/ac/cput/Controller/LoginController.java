package za.ac.cput.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Employee;

@Controller
public class LoginController {
    @RequestMapping("/login")
    public ModelAndView loginEmployee(){
        ModelAndView model = new ModelAndView();
        model.addObject("employee", new Employee());
        model.setViewName("LoginEmployee.html");
        return model;
    }

    @RequestMapping("/loginAdmin")
    public ModelAndView loginAdmin(){
        ModelAndView model = new ModelAndView();
        model.addObject("admin", new Admin());
        model.setViewName("LoginAdmin.html");
        return model;
    }
}
