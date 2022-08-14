package za.ac.cput.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.Domain.Entity.Restaurant;
import za.ac.cput.Service.Impl.RestaurantService;
import za.ac.cput.Service.Impl.RestaurantServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private RestaurantService service;

    @Autowired
    public RestaurantController(RestaurantServiceImpl restaurantService) {
        this.service = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return service.readAll();
    }
}
