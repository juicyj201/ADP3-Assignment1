package za.ac.cput.Impl;

import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Repository.IOrderRepository;

import java.util.HashMap;
import java.util.Map;

public class OrderRepositoryImpl implements IOrderRepository
{
    private static OrderRepositoryImpl orderRepo = null;
    private Map<String, Order> orderDB = null;
    boolean result = false;

    public OrderRepositoryImpl(){
        orderDB = new HashMap<String, Order>();
    }

    public static OrderRepositoryImpl getRepo(){
        if(orderRepo == null){
            orderRepo = new OrderRepositoryImpl();
            return orderRepo;
        }else{
            return null;
        }
    }

    @Override
    public Order create(String id, Order object) {
        //where id = orderID & object = order
        orderDB.put(id, object);
        if(orderDB.containsKey(id)){
            return object;
        }
        return null;
    }

    @Override
    public Order read(String id) {
        for(Order o : orderDB.values()){
            if(o.getOrderId().equalsIgnoreCase(id)){
                return o;
            }
        }
        return null;
    }

    @Override
    public void update(String id, Order object) {
        for(Order o : orderDB.values()){
            if(o.getOrderId().equals(id)){
                orderDB.replace(id, o, object);
            }
        }
    }

    @Override
    public boolean delete(String id) {
        for(Order o : orderDB.values()){
            if(o.getOrderId().equals(id)){
                orderDB.remove(id);
            }
        }
        return false;
    }

    @Override
    public Map<String, Order> getAll() {
        return orderDB;
    }
}