package za.ac.cput.Factory;

/**
 * Delron Chad Claassen
 * 219360561
 * The order factory test */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import za.ac.cput.Domain.Entity.Order;
import za.ac.cput.Factory.OrderFactory;

public class OrderFactoryTest {
    @Test
    public void test(){
        Order order = OrderFactory.createOrder((long) 10000, "STAC001", "Hamburger", "ORNUM001", "Hamburger with large chips.", "####RECEIPT#######");
        System.out.println(order.toString());
        Assertions.assertNotNull(order);
    }
}
