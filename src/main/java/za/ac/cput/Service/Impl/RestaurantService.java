package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface RestaurantService extends IService<Restaurant, Long> {
    @Override
    Restaurant save(Restaurant entity);

    @Override
    Optional<Restaurant> read(Long restaurantID);

    @Override
    void delete(Restaurant entity);

    List<Restaurant> readAll();
}
