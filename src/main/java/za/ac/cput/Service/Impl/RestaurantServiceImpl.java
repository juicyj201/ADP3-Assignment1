package za.ac.cput.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Repository.RestaurantRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Service Impl
 */

@Service
public class RestaurantServiceImpl implements RestaurantService{
    private final RestaurantRepository repo;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repo){
        this.repo = repo;
    }

    @Override
    public Restaurant save(Restaurant restaurant) {
        if(!restaurant.equals(null)) {
            repo.save(restaurant);
            System.out.println("Restaurant saved: ");
            return restaurant;
        }else{
            System.out.println("Error: Restaurant not found");
            return null;
        }
    }

    @Override
    public Optional<Restaurant> read(Long restaurantID) {
        if(restaurantID == 0) {
            System.out.println("Restaurant found: ");
            return repo.findById(restaurantID.toString());
        }else{
            System.out.println("Error: Restaurant not found.");
            return null;
        }
    }

    @Override
    public Optional<Restaurant> read(String ID) {
        return Optional.empty();
    }

    @Override
    public Restaurant update(Restaurant entity) {
        return null;
    }

    @Override
    public void delete(Restaurant restaurant) {
        if(!restaurant.equals(null)) {
            repo.delete(restaurant);
        }else{
            System.out.println("Error: Restaurant not found.");
        }
    }

    @Override
    public List<Restaurant> readAll() {
        if(Collections.emptyList() != repo) {
            return repo.findAll();
        }else{
            System.out.println("Error: Restaurant not found.");
            return null;
        }
    }
}
