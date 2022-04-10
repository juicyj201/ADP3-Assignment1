package za.ac.cput.Impl;

import za.ac.cput.Domain.Entity.Employee;
import za.ac.cput.Repository.IEmployeeRepository;
import java.util.HashMap;
import java.util.Map;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */

public class EmployeeRepositoryImpl implements IEmployeeRepository
{
    private static EmployeeRepositoryImpl empRepo = null;
    private Map<String, Employee> employeeDB = null;
    boolean result = false;

    public EmployeeRepositoryImpl(){
        employeeDB = new HashMap<String, Employee>();
    }

    public static EmployeeRepositoryImpl getRepo(){
        if(empRepo == null){
            empRepo = new EmployeeRepositoryImpl();
            return empRepo;
        }else{
            return null;
        }
    }

    @Override
    public Employee create(String id, Employee object) {
        //where id = employeeNum & object = employee
        employeeDB.put(id, object);
        if(employeeDB.containsKey(id)){
            return object;
        }else{
            return null;
        }
    }

    @Override
    public Employee read(String id) {
        for(Employee e : employeeDB.values()){
            if(e.getEmployeeNum().equals(id)){
                return e;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Employee object) {
        for(Employee e : employeeDB.values()){
            if(e.getEmployeeNum().equals(id)){
                employeeDB.replace(id, e, object);
            }
        }
    }

    @Override
    public boolean delete(String id) {
        for(Employee e : employeeDB.values()){
            if(e.getEmployeeNum().equals(id)){
                employeeDB.remove(id);
            }
        }
        return false;
    }

    @Override
    public Map<String, Employee> getAll() {
        return employeeDB;
    }
}
