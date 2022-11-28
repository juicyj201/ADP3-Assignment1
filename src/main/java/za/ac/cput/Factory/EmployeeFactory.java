package za.ac.cput.Factory;

import za.ac.cput.Domain.Entity.Employee;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */

public class EmployeeFactory
{
    public static Employee createEmployee(Long employeeNum, String empFirstName, String empLastName, String studentAccountID)
    {
        if(employeeNum == null)
            return null;

        return new Employee.EmployeeBuilder().setEmployeeNum(employeeNum)
                .setEmpFirstName(empFirstName)
                .setEmpLastName(empLastName)
                .setStudentAccountID(studentAccountID)
                .build();
    }
}
