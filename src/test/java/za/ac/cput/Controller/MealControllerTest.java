package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Factory.MealFactory;

import static org.junit.jupiter.api.Assertions.*;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MealControllerTest {

    private MealController mealController;
    private Meal newMeal = MealFactory.createMeal(1000L, "Cheeseburger", "Coke", "Peanuts");

    @LocalServerPort
    private int baseport;
    private String baseURL;
    @Autowired
    private TestRestTemplate restTemplate;


    @BeforeEach
    void setUp() {
        assertNotNull(mealController);
        this.newMeal = MealFactory.createMeal(1000L, "Cheeseburger", "Coke", "Peanuts");
        this.baseURL = "http://localhost:"+this.baseport+"/meal/";
        System.out.println(newMeal);
    }


    @Test
    public void addMeal(){
        String url = baseURL + "save/";
        System.out.println(url);
        try {
            Assertions.assertNotNull(mealController.addMeal(newMeal));
        }catch(NullPointerException npe) {
            npe.getMessage();
            npe.getStackTrace();
        }
        System.out.println(this.newMeal.getOrderId()+ ": Has been saved");}

    @Test
    public void testRead(){

        try {
            Assertions.assertNotNull(mealController.getMeal(newMeal));
        }catch(NullPointerException nullPointerException){
            nullPointerException.getMessage();
            nullPointerException.getStackTrace();
        }
        System.out.println("Student Account Found: " + newMeal);
    }


    @Test
    public void testDelete(){
        String url = baseURL + "delete/" + this.newMeal.getOrderId();
        this.restTemplate.delete(url);
        System.out.println("Student Account deleted: " + this.newMeal.getOrderId()+"\n"+url);
    }

    @Test
    public void testUpdate(){
        String url = baseURL + "update/" + this.newMeal.getOrderId();
        System.out.println(url);
        this.restTemplate.put(url, newMeal);
        System.out.println("Student Account updated: " + this.newMeal.getOrderId()+"\n"+url);


    }



}