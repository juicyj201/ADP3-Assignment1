package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
}
