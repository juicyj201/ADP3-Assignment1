//package za.ac.cput.Controller;
//
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import za.ac.cput.Domain.Entity.Employee;
//import za.ac.cput.Service.Impl.EmployeeService;
//import za.ac.cput.Service.Impl.EmployeeServiceImpl;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.logging.Logger;
//
//@RestController
//@RequestMapping("/employee")
//public class EmployeeController {
//    private EmployeeService service;
//    protected final static Logger log = (Logger) LoggerFactory.getLogger(EmployeeController.class);
//
//    @Autowired
//    public EmployeeController(EmployeeServiceImpl employeeService){
//        this.service = employeeService;
//    }
//
//    @PostMapping
//    public Employee saveEmployee(@RequestBody Employee employee){
//        log.info("The request has started");
//        Employee savedEmployee = service.save(employee);
//        log.info("Employee saved to the database");
//        return savedEmployee;
//    }
//
//    @GetMapping
//    public Optional<Employee> getEmployeeByID(Employee employee){
//        log.info("Service started reading employee requested");
//        return service.read(employee);
//    }
//
//    @PutMapping
//    public Employee updateEmployee(Employee employee){
//        log.info("Service started updating the employee request");
//        Employee updatedEmployee = service.update(employee);
//        log.info("Employee "+updatedEmployee.empFirstName +", has been updated.");
//        return updatedEmployee;
//    }
//
//    @DeleteMapping
//    public void deleteEmployee(Employee employee){
//        log.info("Service has started deletion of employee");
//        service.delete(employee);
//        log.info("Employee "+employee.empFirstName +", has been deleted.");
//    }
//
////    @GetMapping
////    public List<Employee> getAllEmployee(){
////        return service.readAll();
////    }
//}
