package cput.ac.za.Domain.Entity;

public class Employee
{
    public final String employeeNum;
    public final String empFirstName;
    public final String empLastName;
    public final String studentAccountID;

    private Employee(EmployeeBuilder builder)
    {
        this.employeeNum = builder.employeeNum;
        this.empFirstName = builder.empFirstName;
        this.empLastName = builder.empLastName;
        this.studentAccountID = builder.studentAccountID;
    }

    public String getEmployeeNum()
    {
        return employeeNum;
    }

    public String getEmpFirstName()
    {
        return empFirstName;
    }

    public String getEmpLastName()
    {
        return empLastName;
    }

    public String getStudentAccountID()
    {
        return studentAccountID;
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
        public final String employeeNum;
        public final String empFirstName;
        public final String empLastName;
        public final String studentAccountID;

        public EmployeeBuilder(String employeeNum, String empFirstName, String empLastName, String studentAccountID)
        {
            this.employeeNum = employeeNum;
            this.empFirstName = empFirstName;
            this.empLastName = empLastName;
            this.studentAccountID = studentAccountID;
        }

        public Employee build() {
            Employee emp = new Employee(this);
            validateEmployeeObject(emp);
            return emp;
        }

        private void validateEmployeeObject(Employee emp) {
            //Code
        }
    }
}
