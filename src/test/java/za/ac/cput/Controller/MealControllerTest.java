package za.ac.cput.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Factory.MealFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MealControllerTest {

    private MealController mealController;
//    private Meal newMeal = MealFactory.createMeal()

    @BeforeEach
    void setUp() {
        assertNotNull(mealController);
    }





}