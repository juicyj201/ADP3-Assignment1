package za.ac.cput.Service.Impl;

import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Service.IService;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Order Service interface
 */

public interface OrderService extends IService<Order, String> {
    public Order save(Order order);
    public Optional<Order> read(Order order);
    public void delete(Order order);
    public List<Order> readAll();
    public Order update(Order order);
}