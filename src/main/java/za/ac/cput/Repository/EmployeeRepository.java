package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
