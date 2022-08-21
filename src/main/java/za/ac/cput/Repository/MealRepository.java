package za.ac.cput.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.Domain.Entity.Meal;

public interface MealRepository extends JpaRepository<Meal, String> {
}