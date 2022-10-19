package za.ac.cput.Service.Impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Repository.OrderRepository;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Order Service interface implementation
 */

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepo;
//    private static OrderService orderService;

//    public static OrderServiceImpl getOrderService() {
//        if(orderService==null) {
//            orderService = new OrderServiceImpl();
//        };
//
//        return (OrderServiceImpl) orderService;
//    }


    public OrderServiceImpl(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order save(Order order) {
        return this.orderRepo.save(order);
    }

    @Override
    public Optional<Order> read(String ID) {
        return Optional.empty();
    }

    @Override
    public Optional<Order> read(Long ID) {
        return this.orderRepo.findById(ID);
    }

    @Override
    public Optional<Order> read(Order order) {
        return this.orderRepo.findById(order.getOrderId());
    }

    @Override
    public void delete(Order order) {
        this.orderRepo.delete(order);
    }

    @Override
    public List<Order> readAll() {
        return this.orderRepo.findAll();
    }

    @Override
    public Order update(Order order) {
        Order oldOrder = null;
        Optional<Order> optionalOrder = orderRepo.findById(order.getOrderId());
        if(optionalOrder.isPresent()) {
            oldOrder = optionalOrder.get();

            oldOrder.setOrderId(order.getOrderId());
            oldOrder.setStudentAccountId(order.getStudentAccountId());
            oldOrder.setStudentMealChoice(order.getStudentMealChoice());
            oldOrder.setOrderNum(order.getOrderNum());
            oldOrder.setOrderDesc(order.getOrderDesc());
            oldOrder.setOrderReceipt(order.getOrderReceipt());
            orderRepo.save(oldOrder);
        } else {
            return new Order();
        }
        return oldOrder;
    }
}
