package za.ac.cput.Controller;

import org.apache.catalina.connector.RequestFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Security.WebSecurityConfig;
import za.ac.cput.Service.Impl.AdminServiceImpl;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static java.lang.String.format;

@Controller
public class MainController {
//    protected final static Logger logger = LoggerFactory.getLogger(MainController.class);
//
//    @RequestMapping("/main")
//    public ModelAndView login(@ModelAttribute("username") String username, @ModelAttribute("password") String password, @ModelAttribute("type") String type) {
//        ModelAndView model = null;
//
////        if (type.equals("off")) {
////            model = new ModelAndView();
////            model.setViewName("view-student-accounts.html");
////            model.addObject("empmessage", format("Employee {username}, successfully logged in."));
////            return model;
////        }
////        else if (type.equals("on")) {
////            model = new ModelAndView();
////            model.setViewName("view-admin-accounts.html");
////            model.addObject("adminmessage", format("Employee {username}, successfully logged in."));
////            return model;
////        }else {
////            model = new ModelAndView();
////            model.setViewName("Error.html");
////            return model;
////        }
//
//        return model;
//    }
}
