package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Entity.Admin;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, String> {
}