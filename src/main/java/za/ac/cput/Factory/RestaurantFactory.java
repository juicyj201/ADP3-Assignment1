package za.ac.cput.Factory;

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
        if(restaurantID == null)
            return null;

        return new Restaurant.RestaurantBuilder().setRestaurantID(restaurantID)
                    .setRestaurantName(restaurantName)
                    .setRestaurantAddr(restaurantAddr)
                    .build();
    }
}
