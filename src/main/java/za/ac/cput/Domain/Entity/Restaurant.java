package za.ac.cput.Domain.Entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Entity
 */

@Entity
@Table(name = "Restaurant")
public class Restaurant
{
    @Id
    @GeneratedValue
    private String restaurantID;
    @Column(name = "resName")
    private String restaurantName;
    @Column(name = "resAddr")
    private String restaurantAddr;

    private Restaurant(RestaurantBuilder builder)
    {
        this.restaurantID = builder.restaurantID;
        this.restaurantName = builder.restaurantName;
        this.restaurantAddr = builder.restaurantAddr;
    }

    public Restaurant() {

    }

    public void setRestaurantID(String restaurantID)
    {
        this.restaurantID = restaurantID;
    }

    public void setRestaurantName(String restaurantName)
    {
        this.restaurantName = restaurantName;
    }

    public void setRestaurantAddr(String restaurantAddr)
    {
        this.restaurantAddr = restaurantAddr;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant restaurant = (Restaurant) o;
        return restaurantID.equals(restaurant.restaurantID) &  restaurantName.equals(restaurant.restaurantName) && restaurantAddr.equals(restaurant.restaurantAddr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantID, restaurantName, restaurantAddr);
    }


    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurantID='" + restaurantID + '\'' +
                ", restaurantName='" + restaurantName + '\'' +
                ", restaurantAddr='" + restaurantAddr + '\'' +
                '}';
    }

    public static class RestaurantBuilder
    {
        private String restaurantID;
        private String restaurantName;
        private String restaurantAddr;

        public RestaurantBuilder setRestaurantID(String restaurantID) {
            this.restaurantID = restaurantID;
            return this;
        }

        public RestaurantBuilder setRestaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public RestaurantBuilder setRestaurantAddr(String restaurantAddr) {
            this.restaurantAddr = restaurantAddr;
            return this;
        }

        public RestaurantBuilder copy(Restaurant restaurant)
        {
            this.restaurantID = restaurant.restaurantID;
            this.restaurantName = restaurant.restaurantName;
            this.restaurantAddr = restaurant.restaurantAddr;
            return this;
        }

        public Restaurant build()
        {
            return new Restaurant(this);
        }
    }
}
