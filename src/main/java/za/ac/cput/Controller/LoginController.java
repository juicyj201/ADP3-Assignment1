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
        model.addObject("id", new Employee());
        model.addObject("pass", new String());
        model.setViewName("Login.html");
        return model;
    }
}
