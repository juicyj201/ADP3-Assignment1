package za.ac.cput.Repository;

import za.ac.cput.Domain.Entity.Employee;

import java.util.Map;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */

public interface IEmployeeRepository extends IRepository<Employee>
{
    public Map<String, Employee> getAll();

    @Override
    public Employee create(String id, Employee object);

    @Override
    public Employee read(String id);

    @Override
    public void update(String id, Employee object);

    @Override
    public void delete(String id);
}
