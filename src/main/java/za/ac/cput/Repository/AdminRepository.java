package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {
}