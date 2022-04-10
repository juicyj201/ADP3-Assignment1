package za.ac.cput.Repository;

import za.ac.cput.Domain.Entity.Restaurant;

import java.util.Map;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Repository
 */

public interface IRestaurantRepository extends IRepository<Restaurant>
{
    public Map<String, Restaurant> getAll();

    @Override
    public Restaurant create(String id, Restaurant object);

    @Override
    public Restaurant read(String id);

    @Override
    public void update(String id, Restaurant object);

    @Override
    public void delete(String id);
}
