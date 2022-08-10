package za.ac.cput.Domain.Factory;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Entity
 */

import za.ac.cput.Domain.Entity.Restaurant;
import org.junit.jupiter.api.Test;
import za.ac.cput.Factory.RestaurantFactory;

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