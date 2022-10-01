package za.ac.cput.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Service.Impl.OrderService;

import java.util.List;
import java.util.Optional;

/**
 * Delron Chad Claassen
 * 219360561
 * Order Controller
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;
    protected final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        logger.info("Saving order...");
        Order savedOrder = orderService.save(order);
        logger.info("Order saved...");
        return savedOrder;
    }

    @GetMapping
    Optional<Order> getOrder(@RequestBody Order order) {
        logger.info("Order request has been initialized...");
        return orderService.read(order);
    }

    /**
    @GetMapping
    public List<Order> getOrders() {
        logger.info("Retrieving orders list...");
        return orderService.readAll();
    }
     **/

    @PutMapping
    Order updateOrder(@RequestBody Order order) {
        logger.info("Request initiated: Updating order...");
        Order updatedOrder = orderService.update(order);
        logger.info("Request finalized: Order#" + updatedOrder.getOrderId() + "#, has been successfully updated!" );
        return updatedOrder;
    }

    @DeleteMapping
    void deleteOrder(@RequestBody Order order) {
        logger.info("Request initiated: Deleting order...");
        orderService.delete(order);
        logger.info("Request finalized: Order#" + order.getOrderId() + "#, has been deleted!");
    }

}

