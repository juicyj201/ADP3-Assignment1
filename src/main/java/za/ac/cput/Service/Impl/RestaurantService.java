package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

public interface RestaurantService extends IService<Restaurant, String> {
    @Override
    Restaurant save(Restaurant entity);

    @Override
    Optional<Restaurant> read(Restaurant entity);

    @Override
    void delete(Restaurant entity);

//    @Override
//    List<Restaurant> readAll();
}
