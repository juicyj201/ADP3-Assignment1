package za.ac.cput.Domain.Factory;

/**
 * Delron Chad Claassen
 * 219360561
 * The meal factory test */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Meal;

public class MealFactoryTest {
    @Test
    public void test(){
        //Assertions.assertEquals(factory.getAdmin("adminJohn"), admin);
        Meal meal = MealFactory.createMeal("ORD001", "Hamburger", "Coke", "N/A");
        System.out.println(meal.toString());
        Assertions.assertNotNull(meal);
    }
}
