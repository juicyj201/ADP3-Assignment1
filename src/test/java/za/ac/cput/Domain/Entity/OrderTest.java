package za.ac.cput.Domain.Entity;


/**
 * Delron Chad Claassen
 * 219360561
 * The order entity test
 */


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    public void test(){
        Order order = new Order.OrderBuilder()
                .setOrderId((long) 10000)
                .setStudentAccountId("STAC001")
                .setStudentMealChoice("Hamburger")
                .setOrderNum("ORNUM001")
                .setOrderDesc("Hamburger with large chips.")
                .setOrderReceipt("########Details#######")
                .build();

        System.out.println(order);
    }

    @AfterAll
    public static void tearDownClass() {
    }
}
