package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Entity.Admin;

import java.util.List;

/**
 * Joshua Julies
 * 220102473
 * The admin repository interface
 */

public interface AdminRepository extends CrudRepository<Admin, Long> {
}