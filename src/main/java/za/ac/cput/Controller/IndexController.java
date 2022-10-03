package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Joshua Julies
 * 220102473
 * The home/index controller
 */

@Controller
public class IndexController {
    @GetMapping({"/", "/index"})
    public String index(@RequestParam(name = "appName", required = false,
            defaultValue = "Restaurant School Management Web Application") String appName,  Model model){
        model.addAttribute("appName", appName);
        return "index";
    }
}
