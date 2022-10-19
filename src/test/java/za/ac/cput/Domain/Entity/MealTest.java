package za.ac.cput.Domain.Entity;

/**
 * Delron Chad Claassen
 * 219360561
 * The meal entity test
 */

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class MealTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        Meal meal = new Meal.MealBuilder()
                .setOrderId((long) 1000000)
                .setStudentMealChoice("Hamburger")
                .setDrink("Pepsi")
                .setAllergens("N/A")
                .build();

        System.out.println(meal);
    }

    @AfterAll
    public static void tearDownClass() {
    }
}
