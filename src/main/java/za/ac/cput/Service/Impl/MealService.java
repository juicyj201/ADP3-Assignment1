package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Meal Service interface
 */

public interface MealService extends IService<Meal, String> {
    public Meal save(Meal meal);
    public Optional<Meal> read(Meal meal);
    public void delete(Meal meal);
    public List<Meal> readAll();
    public Meal update(Meal meal);
}