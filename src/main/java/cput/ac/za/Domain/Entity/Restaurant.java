package cput.ac.za.Domain.Entity;

public class Restaurant
{
    private final String restaurantID;
    private final String restaurantName;
    private final String restaurantAddr;

    private Restaurant(RestaurantBuilder builder)
    {
        this.restaurantID = builder.restaurantID;
        this.restaurantName = builder.restaurantName;
        this.restaurantAddr = builder.restaurantAddr;
    }

    public String getRestaurantID()
    {
        return restaurantID;
    }

    public String getRestaurantName()
    {
        return restaurantName;
    }

    public String getRestaurantAddr()
    {
        return restaurantAddr;
    }

    @Override
    public String toString()
    {
        return "Restaurant{" +
                "restaurantID='" + restaurantID + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddr='" + restaurantAddr + '\'' +
                '}';
    }

    public static class RestaurantBuilder
    {

        private final String restaurantID;
        private final String restaurantName;
        private final String restaurantAddr;

        public RestaurantBuilder(String restaurantID, String restaurantName, String restaurantAddr)
        {
            this.restaurantID = restaurantID;
            this.restaurantName = restaurantName;
            this.restaurantAddr = restaurantAddr;
        }

        public Restaurant build() {
            Restaurant res = new Restaurant(this);
            validateRestaurantObject(res);
            return res;
        }

        private void validateRestaurantObject(Restaurant res) {
            //Code
        }

    }
}
