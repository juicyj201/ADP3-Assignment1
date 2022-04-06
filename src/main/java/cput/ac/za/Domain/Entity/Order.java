package cput.ac.za.Domain.Entity;

public class Order {

    private final String orderId;
    private final String studentAccountId;
    private final String studentMealChoice;
    private final String orderNum;
    private final String OrderDesc;
    private final String orderReceipt;

    private Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.studentAccountId = builder.studentAccountId;
        this.studentMealChoice = builder.studentMealChoice;
        this.orderNum = builder.orderNum;
        this.OrderDesc = builder.OrderDesc;
        this.orderReceipt = builder.orderReceipt;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getStudentAccountId() {
        return studentAccountId;
    }

    public String getStudentMealChoice() {
        return studentMealChoice;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public String getOrderDesc() {
        return OrderDesc;
    }

    public String getOrderReceipt() {
        return orderReceipt;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", studentAccountId='" + studentAccountId + '\'' +
                ", studentMealChoice='" + studentMealChoice + '\'' +
                ", orderNum=" + orderNum +
                ", OrderDesc='" + OrderDesc + '\'' +
                ", orderReceipt='" + orderReceipt + '\'' +
                '}';
    }

    public static class OrderBuilder {

        private final String orderId;
        private final String studentAccountId;
        private String studentMealChoice;
        private String orderNum;
        private String OrderDesc;
        private String orderReceipt;

        public OrderBuilder(String orderId, String studentAccountId) {
            this.orderId = orderId;
            this.studentAccountId = studentAccountId;
        }

        public OrderBuilder studentMealChoice(String studentMealChoice) {
            this.studentMealChoice = studentMealChoice;
            return this;
        }

        public OrderBuilder orderNum(String orderNum) {
            this.orderNum = orderNum;
            return this;
        }

        public OrderBuilder orderDesc(String orderDesc) {
            this.OrderDesc = OrderDesc;
            return this;
        }

        public OrderBuilder orderReceipt(String orderReceipt) {
            this.orderReceipt = orderReceipt;
            return this;
        }

        public Order build() {
            Order order = new Order(this);
            validateOrderObject(order);
            return order;
        }

        private void validateOrderObject(Order order) {
            //Code
        }

    }
}
