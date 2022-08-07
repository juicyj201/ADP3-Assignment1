package za.ac.cput.Impl;

/**
 * Delron Chad Claassen
 * 219360561
 * The Meal Repository implementation
 */

import za.ac.cput.Domain.Entity.Meal;
import za.ac.cput.Repository.IMealRepository;

import java.util.HashMap;
import java.util.Map;

public class MealRepositoryImpl implements IMealRepository
{
    private static MealRepositoryImpl mealRepo = null;
    private Map<String, Meal> mealDB = null;
    boolean result = false;

    public MealRepositoryImpl(){
        mealDB = new HashMap<String, Meal>();
    }

    public static MealRepositoryImpl getRepo(){
        if(mealRepo == null){
            mealRepo = new MealRepositoryImpl();
            return mealRepo;
        }else{
            return null;
        }
    }

    @Override
    public Meal create(String id, Meal object) {
        //where id = orderID & object = meal
        mealDB.put(id, object);
        if(mealDB.containsKey(id)){
            return object;
        }
        return null;
    }

    @Override
    public Meal read(String id) {
        for(Meal m : mealDB.values()){
            if(m.getOrderId().equalsIgnoreCase(id)){
                return m;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Meal object) {
        for(Meal m : mealDB.values()){
            if(m.getOrderId().equals(id)){
                mealDB.replace(id, m, object);
            }
        }
    }

    @Override
    public boolean delete(String id) {
        for(Meal m : mealDB.values()){
            if(m.getOrderId().equals(id)){
                mealDB.remove(id);
            }
        }
        return false;
    }

    @Override
    public Map<String, Meal> getAll() {
        return mealDB;
    }
}

