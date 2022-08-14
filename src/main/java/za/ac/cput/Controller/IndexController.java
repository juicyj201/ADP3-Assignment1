package za.ac.cput.Controller;

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
    @GetMapping
    public String index(){
        return "Index";
    }
}
