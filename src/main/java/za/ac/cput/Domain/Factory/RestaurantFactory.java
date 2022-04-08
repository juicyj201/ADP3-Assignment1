package za.ac.cput.Domain.Factory;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Entity
 */

import za.ac.cput.Domain.Entity.Restaurant;

public class RestaurantFactory
{
    public static Restaurant createRestaurant(String restaurantID, String restaurantName, String restaurantAddr)
    {
        return new Restaurant.RestaurantBuilder().setRestaurantID(restaurantID)
                    .setRestaurantName(restaurantName)
                    .setRestaurantAddr(restaurantAddr)
                    .build();
    }
}
