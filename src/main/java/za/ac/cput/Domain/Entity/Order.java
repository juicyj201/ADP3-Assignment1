package za.ac.cput.Domain.Entity;


import javax.persistence.*;

/**
 * Delron Chad Claassen
 * 219360561
 * The Order Entity
 */

@Entity
@Table(name="Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "STUDENT_ACCOUNT_ID")
    private String studentAccountId;
    @Column(name = "STUDENT_MEAL_CHOICE")
    private String studentMealChoice;
    @Column(name = "ORDER_NUM")
    private String orderNum;
    @Column(name = "ORDER_DESC")
    private String OrderDesc;
    @Column(name = "ORDER_RECEIPT")
    private String orderReceipt;

    private Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.studentAccountId = builder.studentAccountId;
        this.studentMealChoice = builder.studentMealChoice;
        this.orderNum = builder.orderNum;
        this.OrderDesc = builder.OrderDesc;
        this.orderReceipt = builder.orderReceipt;
    }

    public Order() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStudentAccountId() {
        return studentAccountId;
    }

    public void setStudentAccountId(String studentAccountId) {
        this.studentAccountId = studentAccountId;
    }

    public String getStudentMealChoice() {
        return studentMealChoice;
    }

    public void setStudentMealChoice(String studentMealChoice) {
        this.studentMealChoice = studentMealChoice;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOrderDesc() {
        return OrderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        OrderDesc = orderDesc;
    }

    public String getOrderReceipt() {
        return orderReceipt;
    }

    public void setOrderReceipt(String orderReceipt) {
        this.orderReceipt = orderReceipt;
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

    public static class OrderBuilder
    {
        private String orderId;
        private String studentAccountId;
        private String studentMealChoice;
        private String orderNum;
        private String OrderDesc;
        private String orderReceipt;

        public OrderBuilder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder setStudentAccountId(String studentAccountId){
            this.studentAccountId = studentAccountId;
            return this;
        }

        public OrderBuilder setStudentMealChoice(String studentMealChoice) {
            this.studentMealChoice = studentMealChoice;
            return this;
        }

        public OrderBuilder setOrderNum(String orderNum) {
            this.orderNum = orderNum;
            return this;
        }

        public OrderBuilder setOrderDesc(String orderDesc) {
            this.OrderDesc = OrderDesc;
            return this;
        }

        public OrderBuilder setOrderReceipt(String orderReceipt) {
            this.orderReceipt = orderReceipt;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
