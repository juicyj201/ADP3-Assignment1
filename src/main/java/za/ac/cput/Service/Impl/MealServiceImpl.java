package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
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

@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepo;
    private static MealService mealService;

    public static MealServiceImpl getMealService() {
        if(mealService == null){
            mealService = new MealServiceImpl();
        }

        return (MealServiceImpl) mealService;
    }

    public Meal save(Meal meal) {
        return this.mealRepo.save(meal);
    }

    public Optional<Meal> read(Meal meal) {
        return Optional.ofNullable(this.mealRepo.findById(meal.getOrderId()).orElse(null));
    }

    @Override
    public Meal update(Meal meal) {
        Meal oldMeal = null;
        Optional<Meal> optionalMeal = mealRepo.findById(meal.getOrderId());
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

    public List<Meal> readAll() {
        return this.mealRepo.findAll();
    }

    public void delete(Meal meal) {
        this.mealRepo.deleteById(meal.getOrderId());
    }
}
