package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Repository.EmployeeRepository;
import za.ac.cput.Security.EmployeeUserDetails;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Matthew Jones
 * 220077681
 * The Employee Service Impl
 */

@Service
public class EmployeeServiceImpl implements EmployeeService, UserDetailsService {
    private final EmployeeRepository repo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo){
        this.repo = repo;
    }

    @Override
    public Employee save(Employee employee){
        if(!employee.equals(null)) {
            repo.save(employee);
            System.out.println("Employee saved: ");
            return employee;
        }else{
            System.out.println("Error: Employee not found");
            return null;
        }
    }

    @Override
    public Employee readByID(Long employeeNum) {
        if(employeeNum != 0) {
            System.out.println("Admin found: ");
            Employee readEmp = repo.findById(employeeNum).get();
            return readEmp;
        }else{
            System.out.println("Error: Admin not found.");
            return null;
        }
    }

    @Override
    public Optional<Employee> read(Long employeeNum) {
        if(employeeNum != 0) {
            System.out.println("Employee found: ");
            return repo.findById(employeeNum);
        }else{
            System.out.println("Error: Employee not found.");
            return null;
        }
    }

    @Override
    public Employee update(Employee entity) {
        return null;
    }

    @Override
    public void delete(Employee employee) {
        if(!employee.equals(null)) {
            repo.delete(employee);
        }else{
            System.out.println("Error: Employee not found.");
        }
    }

    @Override
    public List<Employee> readAll() {
        if(Collections.emptyList() != repo) {
            return repo.findAll();
        }else{
            System.out.println("Error: Employee not found.");
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(repo.findAll().iterator().next().getEmpFirstName().equals(username)) {
            return new EmployeeUserDetails(repo.findAll().iterator().next());
        }
        return null;
    }
}
