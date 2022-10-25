package za.ac.cput.Controller;

import org.hibernate.mapping.Set;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;

@Controller
@RequestMapping("/")
public class TemplateController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }

    @RequestMapping("/home")
    public String getMain() {
        return "main";
    }

    @RequestMapping("/student-accounts")
    public String getStudent(){
        return "view-student-accounts";
    }

    @RequestMapping("/admin-accounts")
    public String getAdmin(){
        return "view-admin-accounts";
    }

    @RequestMapping("/test")
    public String getTest() {

        return "test";
    }

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
