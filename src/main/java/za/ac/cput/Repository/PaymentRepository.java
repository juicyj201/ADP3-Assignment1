package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Entity.Payment;

/**
 * Joshua Julies
 * 220102473
 * The payment repository interface
 */

public interface PaymentRepository extends JpaRepository<Payment, String> {
}