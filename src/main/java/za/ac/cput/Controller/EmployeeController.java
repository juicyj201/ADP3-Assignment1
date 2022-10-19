package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.Impl.EmployeeService;
import za.ac.cput.Service.Impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * Matthew Jones
 * 220077681
 * The Employee Controller
 */

@RestController
//@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl service;
    protected final static Logger log = LoggerFactory.getLogger(EmployeeController.class);

//    @Autowired
//    public EmployeeController(EmployeeServiceImpl employeeService){
//        this.service = employeeService;
//    }

    @PostMapping("/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        log.info("The request has started");
        Employee savedEmployee = service.save(employee);
        log.info("Employee saved to the database");
        return savedEmployee;
    }

    @GetMapping("/employee/{employee}")
    public Optional<Employee> getEmployeeByID(@PathVariable String employeeID){
        log.info("Service started reading employee requested");
        return service.read(employeeID);
    }

    @PutMapping("/employee")
    public Employee updateEmployee(Employee employee){
        log.info("Service started updating the employee request");
        Employee updatedEmployee = service.update(employee);
        log.info("Employee "+updatedEmployee.empFirstName +", has been updated.");
        return updatedEmployee;
    }

    @DeleteMapping("/employee")
    public void deleteEmployee(Employee employee){
        log.info("Service has started deletion of employee");
        service.delete(employee);
        log.info("Employee "+employee.empFirstName +", has been deleted.");
    }

    @GetMapping
    public List<Employee> getAllEmployee(){
        return service.readAll();
    }
}
