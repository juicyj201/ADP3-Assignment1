package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;

import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private EmployeeServiceImpl service;
    protected final static Logger logger = LoggerFactory.getLogger(MainController.class);

    @RequestMapping("/main")
    public ModelAndView login(@ModelAttribute Employee employee){
        ModelAndView model;
        Optional<Employee> temp = service.read(employee);

        //TODO - check that the employee password is working and that the username exists rather than just the employee password

        if(!temp.equals(null)){
            //if(!temp.get().employeeNum.equals(null) && !temp.get().getPassword().equals(null)){
            model = new ModelAndView();
            model.setViewName("Main.html");
            model.addObject("mainmessage", "Employee "+employee.getEmpFirstName()+", successfully logged in.");
            return model;
            //}
        }
        else{
            model = new ModelAndView();
            model.setViewName("Error.html");
            model.addObject("errormessage", "an error has occurred");
            return model;
        }
    }
}
