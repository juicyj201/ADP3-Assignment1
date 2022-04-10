package za.ac.cput.Impl;

import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Domain.Factory.RestaurantFactory;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryImplTest
{
    private static RestaurantRepositoryImpl resRepo = RestaurantRepositoryImpl.getRepo();
    private static Restaurant restaurant = RestaurantFactory.createRestaurant("101","Jackies","25 No Name Street");

    @Test
    void create()
    {
        Restaurant toCreate = resRepo.create("101",restaurant);
        assertEquals(restaurant.getRestaurantID(), toCreate.getRestaurantID());
        System.out.println("Create: "+toCreate);
    }

    @Test
    void read()
    {
        Restaurant toRead = resRepo.read(restaurant.getRestaurantID());
        assertNotNull(toRead);
        System.out.println("Read: "+ toRead);
    }

    @Test
    void update()
    {
        Restaurant toUpdate = new Restaurant.RestaurantBuilder().copy(restaurant).setRestaurantID("200")
                .setRestaurantName("Johnny")
                .setRestaurantAddr("35 Name Street")
                .build();
        assertNotNull(toUpdate);
        System.out.println("Updated :"+toUpdate);
    }

    @Test
    void delete()
    {
        //Restaurant toDelete = resRepo.delete(restaurant.getRestaurantID());

    }

    @Test
    void getAll()
    {
        System.out.println("Show all:");
        System.out.println(resRepo.getAll());
    }
}