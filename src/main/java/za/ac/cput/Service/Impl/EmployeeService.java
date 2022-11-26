package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends IService<Employee, Long> {
    @Override
    Employee save(Employee employee);

    @Override
    Optional<Employee> read(Long employeeNum);
    Employee readByID(Long employeeNum);

    @Override
    void delete(Employee employee);

    List<Employee> readAll();
}
