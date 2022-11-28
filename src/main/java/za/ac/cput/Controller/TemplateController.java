package za.ac.cput.Controller;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Domain.Entity.StudentAccount;
import za.ac.cput.Service.Impl.OrderServiceImpl;
import za.ac.cput.Service.Impl.StudentAccountServiceImpl;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/")
public class TemplateController {
    @Autowired
    private StudentAccountServiceImpl studentAccountService;
    @Autowired
    private OrderServiceImpl orderservice;

    /**
     * @method getIndex
     * ----------------
     * This brings the user to the index page
     *
     * @return - it returns a string attribute that links to the index webpage
     */
    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    /**
     * @method getLogin
     * ----------------
     * This brings the user to the login page. Authentication and credentials
     * are checked here, and rememberme functionality is added
     *
     * @return - it returns a string attribute that links to the login webpage
     */
    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    /**
     * @method getMain
     * ----------------
     * This brings the user to the home page, where they can access admin
     * or student account information.
     *
     * @return - it returns a string attribute that links to the home page
     */
    @RequestMapping("/home")
    public String getMain() {
        return "main";
    }

    /**
     * @method getTest
     * ----------------
     * This is not an official page, just merely for testing out new
     * functionality or system bugs.
     *
     * @return - it returns a string attribute that links to the test webpage
     */
    @RequestMapping("/test")
    public String getTest() {
        return "test";
    }

    /**
     * @method getStudent
     * ------------------
     * This controller adds all student and all related orders
     * to the student account web page.
     *
     * @return - it returns a ModelAndView object which is necessary for the model-object structure we have.
     */
    @RequestMapping("/student-accounts")
    public ModelAndView getStudent(){
        ModelAndView model = new ModelAndView();
        model.addObject("students", (List<StudentAccount>) studentAccountService.readAll());
        model.addObject("orders", (List<Order>) orderservice.readAll());
        model.setViewName("view-student-accounts.html");
        return model;
    }

    /**
     * @method getLoggedInUser
     * ----------------------
     * This checks if the user is logged in
     *
     * @param auth - this allows authentication support for user information
     * @return - it returns a ModelAndView object which is necessary for the model-object structure we have.
     */
    @RequestMapping("/logged-in")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE', 'ROLE_STUDENT')")
    public ModelAndView getLoggedInUser(Authentication auth) {
        Collection auths = auth.getAuthorities();
        Object ofAuths[] = auths.toArray();
        Object type = ofAuths[0];

        ModelAndView model = new ModelAndView();
        model.addObject("username", auth.getName());
        model.addObject("credentials", auth.getCredentials());
        model.addObject("authenticated", auth.isAuthenticated());
        model.addObject("authority", type.toString());
        model.setViewName("LoggedInUser");
        return model;
    }
}
