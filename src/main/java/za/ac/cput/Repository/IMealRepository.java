package za.ac.cput.Repository;

import za.ac.cput.Domain.Entity.Meal;

import java.util.Map;

public interface IMealRepository extends IRepository<Meal> {
    public Map<String, Meal> getAll();

    @Override
    public Meal create(String id, Meal Object);

    @Override
    public Meal read(String id);

    @Override
    public void update(String id, Meal object);

    @Override
    public boolean delete(String id);
}