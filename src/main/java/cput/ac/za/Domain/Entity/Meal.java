package cput.ac.za.Domain.Entity;

public class Meal {

    private final String orderId;
    private final String studentMealChoice;
    private final String drink;
    private final String allergens;


    private Meal(MealBuilder builder) {
        this.orderId = builder.orderId;
        this.studentMealChoice = builder.studentMealChoice;
        this.drink = builder.drink;
        this.allergens = builder.allergens;
    }


    public String getOrderId() {
        return orderId;
    }

    public String getStudentMealChoice() {
        return studentMealChoice;
    }

    public String getDrink() {
        return drink;
    }

    public String getAllergens() {
        return allergens;
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

    public static class MealBuilder {

        private final String orderId;
        private final String studentMealChoice;
        private String drink;
        private String allergens;

        public MealBuilder(String orderId, String studentMealChoice) {
            this.orderId = orderId;
            this.studentMealChoice = studentMealChoice;
        }

        public MealBuilder drink(String drink) {
            this.drink = drink;
            return this;
        }

        public MealBuilder allergens(String allergens) {
            this.allergens = allergens;
            return this;
        }

        public Meal build() {
            Meal meal = new Meal(this);
            validateOrderObject(meal);
            return meal;
        }

        private void validateOrderObject(Meal meal) {
            //Code
        }

    }

}
