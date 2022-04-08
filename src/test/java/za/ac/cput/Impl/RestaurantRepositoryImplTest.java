package za.ac.cput.Impl;

import org.junit.jupiter.api.BeforeAll;
import org.testng.Assert;
import org.testng.annotations.Test;

import za.ac.cput.Domain.Entity.Restaurant;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantRepositoryImplTest
{
    private RestaurantRepositoryImpl resRepo = new RestaurantRepositoryImpl();
    private RestaurantRepositoryImpl resRepo2;
    private Restaurant restaurant;
    private Restaurant newRes;
    private RestaurantRepositoryImpl resRepo3 = new RestaurantRepositoryImpl();

    @BeforeAll
    public void setUp(){
        restaurant = new Restaurant.RestaurantBuilder().build();
        newRes = new Restaurant.RestaurantBuilder().build();
        resRepo2 = new RestaurantRepositoryImpl();
        resRepo2.create("007", restaurant);
        resRepo3.create("007", restaurant);
    }

    @Test
    public void getRepo(){
        Assert.assertNotNull(resRepo);
    }

    @Test
    public void create(){
        Assert.assertEquals(resRepo3.create("007", restaurant), resRepo2);
    }
}