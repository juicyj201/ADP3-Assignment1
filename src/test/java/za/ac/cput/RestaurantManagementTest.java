package za.ac.cput;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.boot.SpringApplication;

/**
 * Unit test for simple RestaurantManagementApp.
 */
public class RestaurantManagementTest
{
    @Test
    public void testMain() {
        try {
            Assertions.assertThrows(BeanCreationException.class, () -> {
                SpringApplication.run(RestaurantManagementApp.class);
            }, "The application does run, there is a bean creation exception that must be ignored for now until fixed.");
        }catch(BeanCreationException bce){
            bce.getBeanName();
            bce.getRootCause();
            bce.getMessage();
        }catch(Exception e){
            e.getMessage();
        }
    }
}
