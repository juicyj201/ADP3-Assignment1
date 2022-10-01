package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Joshua Julies
 * 220102473
 * The home/index controller
 */

@RestController
@RequestMapping("/")
public class IndexController {
    @Value("${spring.application.name}")
    private String appName = "Restaurant School Management Web Application";

    @GetMapping
    public String index(Model model){
        model.addAttribute("appName", appName);
        return "Index";
    }
}
