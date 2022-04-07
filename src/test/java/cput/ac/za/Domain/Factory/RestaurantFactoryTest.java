package cput.ac.za.Domain.Factory;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Entity
 */

import cput.ac.za.Domain.Entity.Restaurant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantFactoryTest
{
    @Test
    public void test()
    {
        Restaurant restaurant = RestaurantFactory.createRestaurant("001","Gordon Kitchen","25 Long Road");
        System.out.println(restaurant.toString());
        assertNotNull(restaurant);
    }
}