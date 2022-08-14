package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.Impl.EmployeeService;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeServiceImpl employeeService){
        this.service = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return service.readAll();
    }
}
