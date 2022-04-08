package za.ac.cput.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;
import za.ac.cput.Domain.Entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest
{
    private EmployeeRepositoryImpl empRepo = new EmployeeRepositoryImpl();
    private EmployeeRepositoryImpl empRepo2;
    private Employee employee;
    private Employee newEmp;
    private EmployeeRepositoryImpl empRepo3 = new EmployeeRepositoryImpl();

    @BeforeAll
    public void setUp(){
        employee = new Employee.EmployeeBuilder().build();
        newEmp = new Employee.EmployeeBuilder().build();
        empRepo2 = new EmployeeRepositoryImpl();
        empRepo2.create("120", employee);
        empRepo3.create("120", employee);
    }

    @Test
    public void getRepo(){
        Assert.assertNotNull(empRepo);
    }

    @Test
    public void create(){
        Assert.assertEquals(empRepo3.create("120", employee), empRepo2);
    }
}