package za.ac.cput.Impl;

import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Repository.IRestaurantRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * Matthew Jones
 * 220077681
 * The Employee Entity
 */

public class RestaurantRepositoryImpl implements IRestaurantRepository
{
    private static RestaurantRepositoryImpl resRepo = null;
    private Map<String, Restaurant> restaurantDB = null;
    boolean result = false;

    private RestaurantRepositoryImpl(){
        restaurantDB = new HashMap<String, Restaurant>();
    }

    public static RestaurantRepositoryImpl getRepo(){
        if(resRepo == null){
            resRepo = new RestaurantRepositoryImpl();
            return resRepo;
        }else{
            return null;
        }
    }

    @Override
    public Restaurant create(String id, Restaurant object) {
        //where id = restaurantID & object = restaurant
        restaurantDB.put(id, object);
        if(restaurantDB.containsKey(id)){
            return object;
        }else{
            return null;
        }
    }

    @Override
    public Restaurant read(String id) {
        for(Restaurant r : restaurantDB.values()){
            if(r.getRestaurantID().equals(id)){
                return r;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Restaurant object) {
        for(Restaurant r : restaurantDB.values()){
            if(r.getRestaurantID().equals(id)){
                restaurantDB.replace(id, r, object);
            }
        }
    }

    @Override
    public void delete(String id) {
        for(Restaurant r : restaurantDB.values()){
            if(r.getRestaurantID().equals(id)){
                restaurantDB.remove(id);
            }
        }
    }

    @Override
    public Map<String, Restaurant> getAll() {
        return restaurantDB;
    }
}
