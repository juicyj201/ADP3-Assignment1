package za.ac.cput.Factory;

/**
 * Delron Chad Claassen
 * 219360561
 * The Order Factory
 */

import za.ac.cput.Domain.Entity.Order;

public class OrderFactory {
    public static Order createOrder(Long orderId, String studentAccountId, String studentMealChoice, String orderNum, String orderDesc, String orderReceipt)
    {
        if(orderId == null)
            return null;

        return new Order.OrderBuilder().setOrderId(orderId)
                .setStudentAccountId(studentAccountId)
                .setStudentMealChoice(studentMealChoice)
                .setOrderNum(orderNum)
                .setOrderDesc(orderDesc)
                .setOrderReceipt(orderReceipt)
                .build();
    }
}
