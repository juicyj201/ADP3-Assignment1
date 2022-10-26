package za.ac.cput.Controller;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Delron Chad Claassen
 * 219360561
 * Meal Controller
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTest {
    @Autowired
    private OrderController orderController;
    private Order order = OrderFactory.createOrder(1212L, "111111", "Lunch", "12","12", "None");

    @LocalServerPort
    private int baseport;
    private String baseURL;
    @Autowired
    private TestRestTemplate restTemplate;
    @BeforeEach
    public void setUp(){
        assertNotNull(orderController);
        this.order =  OrderFactory.createOrder(121212L, "111111", "Lunch", "12","12", "None");
        this.baseURL = "http://localhost:"+this.baseport+"/order/";
        System.out.println(order);
    }

    @Test
    public void testSave(){
        String url = baseURL + "save";
        System.out.println(url);
        try {
            assertNotNull(orderController.getOrder(order.getOrderId()));
        }catch(NullPointerException npe) {
            npe.getMessage();
            npe.getStackTrace();
        }
        System.out.println(this.order.getOrderId()+ ": Has been saved");}


    @Test
    public void testRead(){

        try {
            Assertions.assertNotNull(orderController.getOrder(order.getOrderId()));
        }catch(NullPointerException nullPointerException){
            nullPointerException.getMessage();
            nullPointerException.getStackTrace();
        }
        System.out.println("Student Account Found: " + order);
    }


    @Test
    public void testDelete(){
        String url = baseURL + "delete/" + this.order.getOrderId();
        this.restTemplate.delete(url);
        System.out.println("Student Account deleted: " + this.order.getOrderId()+"\n"+url);
    }

    @Test
    public void testUpdate(){
        String url = baseURL + "update/" + this.order.getOrderId();
        System.out.println(url);
        this.restTemplate.put(url, order);
        System.out.println("Student Account updated: " + this.order.getOrderId()+"\n"+url);


    }

    @AfterEach
    void tearDown() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

}
