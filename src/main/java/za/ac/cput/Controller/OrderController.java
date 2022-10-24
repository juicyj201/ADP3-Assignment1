package za.ac.cput.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
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


    @GetMapping("read")
    Optional<Order> getOrder(@RequestBody Order order) {
        log.info("Order request has been initialized...");
        return Optional.ofNullable(orderService.read(order).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }

    @GetMapping("orders")
    //Permission at a method level
    // Users with role -> (Admin, Employee) can access this method
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_EMPLOYEE')")
    public List<Order> getOrders(Model model) {
        log.info("Retrieving orders list...");
        return orderService.readAll();
    }

    @PostMapping("save")
    // Users with permission -> (write) can access this method
    @PreAuthorize("hasAuthority('order:write')")
    public Order addOrder(@RequestBody Order order) {
        log.info("Creating order: {}", order.getOrderId());
        Order savedOrder = orderService.save(order);
        log.info("Order ID: {} created successfully!", order.getOrderId());
        return savedOrder;
    }

    @PutMapping("update")
    // Users with permission -> (write) can access this method
    @PreAuthorize("hasAuthority('order:write')")
    Order updateOrder(@RequestBody Order order) {
        log.info("Request initiated: Updating order...");
        Order updatedOrder = orderService.update(order);
        log.info("Request finalized: Order#" + updatedOrder.getOrderId() + "#, has been successfully updated!" );
        return updatedOrder;
    }

    @DeleteMapping("delete")
    // Users with permission -> (write) can access this method
    @PreAuthorize("hasAuthority('order:write')")
    void deleteOrder(@RequestBody Order order) {
        log.info("Request initiated: Deleting order...");
        orderService.delete(order);
        log.info("Request finalized: Order#" + order.getOrderId() + "#, has been deleted!");
    }
}

