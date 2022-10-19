package za.ac.cput.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Repository.MealRepository;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Meal Service interface implementation
 */

@Slf4j
@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepo;

    public MealServiceImpl(MealRepository mealRepo) {
        this.mealRepo = mealRepo;
    }

    @Override
    public Meal save(Meal meal) {
        return this.mealRepo.save(meal);
    }

    @Override
    public Optional<Meal> read(String ID) {
        return Optional.empty();
    }

    @Override
    public Optional<Meal> read(Long ID) {
        return Optional.empty();
    }

    @Override
    public Optional<Meal> read(Meal meal) {
        return this.mealRepo.findById(meal.getOrderId());
    }

    @Override
    public Meal update(Meal meal) {
        Meal oldMeal = null;
        Optional<Meal> optionalMeal = this.mealRepo.findById(meal.getOrderId());
        if(optionalMeal.isPresent()) {
            oldMeal = optionalMeal.get();
            oldMeal.setStudentMealChoice(meal.getStudentMealChoice());
            oldMeal.setDrink(meal.getDrink());
            oldMeal.setAllergens(meal.getAllergens());
            mealRepo.save(oldMeal);
        } else {
            return new Meal();
        }
        return oldMeal;
    }

    @Override
    public List<Meal> readAll() {
        return this.mealRepo.findAll();
    }

    @Override
    public void delete(Meal meal) {
        if (meal != null) {
            this.mealRepo.deleteById(meal.getOrderId());
        } else {
            log.info("Failed. Meal doesn't exist.");
        };
    }
}
