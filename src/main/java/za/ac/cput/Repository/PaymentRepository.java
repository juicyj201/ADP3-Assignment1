package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.Domain.Entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {
}