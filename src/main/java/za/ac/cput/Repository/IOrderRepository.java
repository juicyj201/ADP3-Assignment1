package za.ac.cput.Repository;

/**
 * Delron Chad Claassen
 * 219360561
 * The meal repository interface
 */

import za.ac.cput.Domain.Entity.Order;

import java.util.Map;

public interface IOrderRepository extends IRepository<Order> {
    public Map<String, Order> getAll();

    @Override
    public Order create(String id, Order Object);

    @Override
    public Order read(String id);

    @Override
    public void update(String id, Order object);

    @Override
    public boolean delete(String id);
}
