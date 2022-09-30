package za.ac.cput.Controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Service.Impl.OrderService;
import za.ac.cput.Service.Impl.OrderServiceImpl;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Order Controller
 */

@RestController
@Slf4j
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @PostMapping("save")
    public Order addOrder(@RequestBody Order order) {
        log.info("Creating order: {}", order.getOrderId());
        Order savedOrder = orderService.save(order);
        log.info("Order ID: {} created successfully!", order.getOrderId());
        return savedOrder;
    }

    @GetMapping("read")
    Optional<Order> getOrder(@RequestBody Order order) {
        log.info("Order request has been initialized...");
        return Optional.ofNullable(orderService.read(order).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("readAll")
    public List<Order> getOrders() {
        log.info("Retrieving orders list...");
        return orderService.readAll();
    }

    @PutMapping("update")
    Order updateOrder(@RequestBody Order order) {
        log.info("Request initiated: Updating order...");
        Order updatedOrder = orderService.update(order);
        log.info("Request finalized: Order#" + updatedOrder.getOrderId() + "#, has been successfully updated!" );
        return updatedOrder;
    }

    @DeleteMapping("delete")
    void deleteOrder(@RequestBody Order order) {
        log.info("Request initiated: Deleting order...");
        orderService.delete(order);
        log.info("Request finalized: Order#" + order.getOrderId() + "#, has been deleted!");
    }
}

