package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
