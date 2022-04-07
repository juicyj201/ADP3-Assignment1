package cput.ac.za.Domain.Factory;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Entity
 */

import cput.ac.za.Domain.Entity.Restaurant;

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
