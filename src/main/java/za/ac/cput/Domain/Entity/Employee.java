package za.ac.cput.Domain.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */
@Entity
@Table(name = "Employee")
public class Employee
{
    @Id
    @Column(name = "employeeNum")
    public String employeeNum;
    @Column(name = "empFirstName")
    public String empFirstName;
    @Column(name = "empLastName")
    public String empLastName;
    public String studentAccountID;
    protected String password;

    private Employee(EmployeeBuilder builder)
    {
        this.employeeNum = builder.employeeNum;
        this.empFirstName = builder.empFirstName;
        this.empLastName = builder.empLastName;
        this.studentAccountID = builder.studentAccountID;
    }

    public Employee() {

    }

    public String getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(String employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getEmpFirstName() {
        return empFirstName;
    }

    public void setEmpFirstName(String empFirstName) {
        this.empFirstName = empFirstName;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getStudentAccountID() {
        return studentAccountID;
    }

    public void setStudentAccountID(String studentAccountID) {
        this.studentAccountID = studentAccountID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeNum.equals(employee.employeeNum) && empFirstName.equals(employee.empFirstName) && empLastName.equals(employee.empLastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNum, empFirstName, empLastName);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "employeeNum='" + employeeNum + '\'' +
                ", empFirstName='" + empFirstName + '\'' +
                ", empLastName='" + empLastName + '\'' +
                ", studentAccountID='" + studentAccountID + '\'' +
                '}';
    }

    public static class EmployeeBuilder
    {
        public String employeeNum;
        public String empFirstName;
        public String empLastName;
        public String studentAccountID;

        public EmployeeBuilder setEmployeeNum(String employeeNum) {
            this.employeeNum = employeeNum;
            return this;
        }

        public EmployeeBuilder setEmpFirstName(String empFirstName) {
            this.empFirstName = empFirstName;
            return this;
        }

        public EmployeeBuilder setEmpLastName(String empLastName) {
            this.empLastName = empLastName;
            return this;
        }

        public EmployeeBuilder setStudentAccountID(String studentAccountID) {
            this.studentAccountID = studentAccountID;
            return this;
        }

        public EmployeeBuilder copy(Employee employee)
        {
            this.employeeNum = employee.employeeNum;
            this.empFirstName = employee.empFirstName;
            this.empLastName = employee.empLastName;
            this.studentAccountID = employee.studentAccountID;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
}
