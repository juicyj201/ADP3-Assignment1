package za.ac.cput.Domain.Entity;

import javax.persistence.*;

/**
 * Delron Chad Claassen
 * 219360561
 * The Meal Entity
 */

@Entity
@Table(name="Meal")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private String orderId;
    @Column(name = "STUDENT_MEAL_CHOICE")
    private String studentMealChoice;
    @Column(name = "DRINK")
    private String drink;
    @Column(name = "ALLERGENS")
    private String allergens;

    private Meal(MealBuilder builder) {
        this.orderId = builder.orderId;
        this.studentMealChoice = builder.studentMealChoice;
        this.drink = builder.drink;
        this.allergens = builder.allergens;
    }

    public Meal() {

    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStudentMealChoice() {
        return this.studentMealChoice;
    }

    public void setStudentMealChoice(String studentMealChoice) {
        this.studentMealChoice = studentMealChoice;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "orderId='" + orderId + '\'' +
                ", studentMealChoice='" + studentMealChoice + '\'' +
                ", drink='" + drink + '\'' +
                ", allergens='" + allergens + '\'' +
                '}';
    }

    public static class MealBuilder
    {
        private String orderId;
        private String studentMealChoice;
        private String drink;
        private String allergens;

        public MealBuilder setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public MealBuilder setStudentMealChoice(String studentMealChoice) {
            this.studentMealChoice = studentMealChoice;
            return this;
        }

        public MealBuilder setDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public MealBuilder setAllergens(String allergens) {
            this.allergens = allergens;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }

    }

}