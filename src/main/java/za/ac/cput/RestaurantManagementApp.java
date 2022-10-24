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
    public static void main( String[] args )
    {
        SpringApplication.run(RestaurantManagementApp.class, args);
    }
}
