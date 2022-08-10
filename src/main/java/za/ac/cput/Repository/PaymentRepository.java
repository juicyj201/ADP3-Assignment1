package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {
}