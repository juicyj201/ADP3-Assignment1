package za.ac.cput.Impl;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Domain.Factory.OrderFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Delron Chad Claassen
 * 219360561
 * The order repository test
 */

public class OrderRepositoryImplTest {
    public static OrderRepositoryImpl repo = OrderRepositoryImpl.getRepo();
    public static Order order = OrderFactory
            .createOrder("ORD001", "STAC001", "Hamburger", "ORDNUM001", "Hamburger and large chips.", "####RECEIPT####");

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create(){
        Order created = repo.create("001", order);
        assertEquals(order.getOrderId(), created.getOrderId());
        System.out.println("Order created: " + created);
    }

    @Test
    void read(){
        Order read = repo.read(order.getOrderId());
        assertNotNull(read);
    }

    @Test
    void update(){
    }

    @Test
    void delete(){
    }

    @Test
    void getAll(){
        System.out.println(repo.getAll());
    }

    @Test
    public void test(){
        OrderRepositoryImpl repo = OrderRepositoryImpl.getRepo();
    }

    @AfterAll
    public static void tearDownClass() {
    }

}
