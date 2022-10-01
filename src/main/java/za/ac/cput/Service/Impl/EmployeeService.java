package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Admin;
import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends IService<Employee, String> {
    /**public Employee save(Employee employee);
    public Optional<Employee> read(Employee employee);
    public List<Employee> readAll();
    public Employee update(Employee employee);
    public void delete(Employee employee);
    **/

    @Override
    Employee save(Employee employee);

    @Override
    Optional<Employee> read(Employee employee);

    @Override
    void delete(Employee employee);

    List<Employee> readAll();
}
