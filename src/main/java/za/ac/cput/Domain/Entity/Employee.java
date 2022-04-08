package za.ac.cput.Domain.Entity;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */

public class Employee
{
    public String employeeNum;
    public String empFirstName;
    public String empLastName;
    public String studentAccountID;

    private Employee(EmployeeBuilder builder)
    {
        this.employeeNum = builder.employeeNum;
        this.empFirstName = builder.empFirstName;
        this.empLastName = builder.empLastName;
        this.studentAccountID = builder.studentAccountID;
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

        public Employee build()
        {
            return new Employee(this);
        }
    }
}
