package za.ac.cput.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Service.Impl.RestaurantService;
import za.ac.cput.Service.Impl.RestaurantServiceImpl;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Matthew Jones
 * 220077681
 * The Restaurant Controller
 */

//@RestController
//@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantService service;
    protected final static Logger log = (Logger) LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.service = restaurantService;
    }

    @PostMapping
    public Restaurant saveRestaurant(@RequestBody Restaurant restaurant){
        log.info("The request has started");
        Restaurant savedRestaurant = service.save(restaurant);
        log.info("Restaurant saved to the database");
        return savedRestaurant;
    }

    @GetMapping
    public Optional<Restaurant> getRestaurantByID(Restaurant restaurant){
        log.info("Service started reading restaurant requested");
        return service.read(restaurant);
    }

    @PutMapping
    public Restaurant updateRestaurant(Restaurant restaurant){
        log.info("Service started updating the restaurant request");
        Restaurant updatedRestaurant = service.update(restaurant);
        log.info("Restaurant "+updatedRestaurant.getRestaurantID() +", has been updated.");
        return updatedRestaurant;
    }

    @DeleteMapping
    public void deleteEmployee(Restaurant restaurant){
        log.info("Service has started deletion of restaurant");
        service.delete(restaurant);
        log.info("Restaurant "+restaurant.getRestaurantName() +", has been deleted.");
    }

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return service.readAll();
    }
}
