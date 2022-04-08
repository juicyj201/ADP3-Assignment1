package cput.ac.za.Domain.Factory;

import cput.ac.za.Domain.Entity.Employee;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */

public class EmployeeFactory
{
    public static Employee createEmployee(String employeeNum, String empFirstName, String empLastName, String studentAccountID)
    {
        return new Employee.EmployeeBuilder().setEmployeeNum(employeeNum)
                .setEmpFirstName(empFirstName)
                .setEmpLastName(empLastName)
                .setStudentAccountID(studentAccountID)
                .build();
    }
}
