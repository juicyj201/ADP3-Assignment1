package za.ac.cput.Impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Domain.Entity.Student;
import za.ac.cput.Domain.Factory.MealFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Delron Chad Claassen
 * 219360561
 * The meal repository implementation test
 */

public class MealRepositoryImplTest {

    public static MealRepositoryImpl repo = MealRepositoryImpl.getRepo();
    public static Meal meal = MealFactory
            .createMeal("ORD001", "Hamburger", "Pepsi", "N/A");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create(){
        Meal created = repo.create("001", meal);
        assertEquals(meal.getOrderId(), created.getOrderId());
        System.out.println("Order created: " + created);
    }

    @Test
    void read(){
        Meal read = repo.read(meal.getOrderId());
        assertNotNull(read);
    }

    @Test
    void update(){
    }

    @Test
    void delete(){
    }

    @Test
    void getAll(){
        System.out.println(repo.getAll());
    }

    @Test
    public void test(){
        MealRepositoryImpl repo = MealRepositoryImpl.getRepo();
    }

    @AfterAll
    public static void tearDownClass() {
    }

}
