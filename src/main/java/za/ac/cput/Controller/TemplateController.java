package za.ac.cput.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

}
