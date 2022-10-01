package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Service.Impl.MealService;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Meal Controller
 */

@RestController
@RequestMapping("/meal")
public class MealController {

    private MealService mealService;
    protected final static Logger logger = LoggerFactory.getLogger(MealController.class);

    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping
    public Meal addMeal(@RequestBody Meal meal) {
        logger.info("Saving meal...");
        Meal savedMeal = mealService.save(meal);
        logger.info("Meal saved...");
        return savedMeal;
    }

    @GetMapping
    Optional<Meal> getMeal(@RequestBody Meal meal) {
        logger.info("Meal request has been initialized...");
        return mealService.read(meal);
    }

    /**
    @GetMapping
    public List<Meal> getMeals() {
        logger.info("Retrieving meal list...");
        return mealService.readAll();
    }
     **/

    @PutMapping
    Meal updateMeal(@RequestBody Meal meal) {
        logger.info("Request initiated: Updating meal...");
        Meal updatedMeal = mealService.update(meal);
        logger.info("Request finalized: Meal " +updatedMeal.getOrderId()+ ", has been successfully updated!" );
        return updatedMeal;
    }

    @DeleteMapping
    void deleteMeal(@RequestBody Meal meal) {
        logger.info("Request initiated: Deleting meal...");
        mealService.delete(meal);
        logger.info("Request finalized: Meal with" +meal.getOrderId()+ ", has been deleted!");
    }

}
