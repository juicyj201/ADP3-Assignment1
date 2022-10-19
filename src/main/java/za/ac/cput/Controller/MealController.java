package za.ac.cput.Controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Service.Impl.MealService;
import za.ac.cput.Service.Impl.MealServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Meal Controller
 */

@RestController
@Slf4j
@RequestMapping("/meal")
public class MealController {

    private final MealService mealService;

    @Autowired
    public MealController(MealServiceImpl mealService) {
        this.mealService = mealService;
    }

    @PostMapping("save")
    public Meal addMeal(@RequestBody Meal meal) {
        log.info("Creating meal: {}", meal.getOrderId());
        Meal savedMeal = mealService.save(meal);
        log.info("Meal ID: #{} created successfully!", meal.getOrderId());
        return savedMeal;
    }

    @GetMapping("read")
    Optional<Meal> getMeal(@RequestBody Meal meal) {
        log.info("Meal request has been initialized...");
        return Optional.ofNullable(mealService.read(meal).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("readAll")
    public List<Meal> getMeals() {
        log.info("Retrieving meal list...");
        return mealService.readAll();
    }

    @PutMapping("update")
    Meal updateMeal(@RequestBody Meal meal) {
        log.info("Request initiated: Updating meal {}...", meal);
        Meal updatedMeal = mealService.update(meal);
        log.info("Request finalized: #{}, has been successfully updated!", updatedMeal.getOrderId());
        return updatedMeal;
    }

    @DeleteMapping("delete")
    void deleteMeal(@RequestBody Meal meal) {
        log.info("Request initiated: Deleting meal {}...", meal);
        mealService.delete(meal);
        log.info("Request finalized: Meal  #{}, has been deleted!", meal.getOrderId());
    }

}
