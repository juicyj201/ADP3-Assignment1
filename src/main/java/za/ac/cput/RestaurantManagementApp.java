package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Joshua Julies
 * 220102473
 * The Spring Boot Application
 */ 

@SpringBootApplication
public class RestaurantManagementApp
{
    /**
     * @method main
     * ------------
     * Runs and compiles the spring boot application live
     *
     * @param args
     */
    public static void main( String[] args )
    {
        SpringApplication.run(RestaurantManagementApp.class, args);
    }
}
