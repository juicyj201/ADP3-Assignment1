package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends IService<Employee, String > {
    @Override
    Employee save(Employee employee);

    @Override
    Optional<Employee> read(Employee employee);

    @Override
    void delete(Employee employee);

    List<Employee> readAll();
}
