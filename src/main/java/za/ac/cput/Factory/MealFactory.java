package za.ac.cput.Factory;

/**
 * Delron Chad Claassen
 * 219360561
 * The Order Factory
 */

import za.ac.cput.Domain.Entity.Meal;

public class MealFactory
{
    public static Meal createMeal(Long orderId, String studentMealChoice, String drink, String allergens)
    {
        if(orderId == null)
            return null;

        return new Meal.MealBuilder().setOrderId(orderId)
                .setStudentMealChoice(studentMealChoice)
                .setDrink(drink)
                .setAllergens(allergens)
                .build();
    }
}
