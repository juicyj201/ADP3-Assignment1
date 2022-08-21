//package za.ac.cput.Service.Impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import za.ac.cput.Domain.Entity.Restaurant;
//import za.ac.cput.Repository.RestaurantRepository;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
//public class RestaurantServiceImpl implements RestaurantService{
//    private final RestaurantRepository repo;
//
//    @Autowired
//    public RestaurantServiceImpl(RestaurantRepository repo){
//        this.repo = repo;
//    }
//
//    @Override
//    public Restaurant save(Restaurant restaurant) {
//        if(!restaurant.equals(null)) {
//            repo.save(restaurant);
//            System.out.println("Restaurant saved: ");
//            return restaurant;
//        }else{
//            System.out.println("Error: Restaurant not found");
//            return null;
//        }
//    }
//
//    @Override
//    public Optional<Restaurant> read(Restaurant restaurant) {
//        if(!restaurant.equals(null)) {
//            System.out.println("Restaurant found: ");
//            return repo.findById(restaurant.getRestaurantID());
//        }else{
//            System.out.println("Error: Restaurant not found.");
//            return null;
//        }
//    }
//
//    @Override
//    public Restaurant update(Restaurant entity) {
//        return null;
//    }
//
//    @Override
//    public void delete(Restaurant restaurant) {
//        if(!restaurant.equals(null)) {
//            repo.delete(restaurant);
//        }else{
//            System.out.println("Error: Restaurant not found.");
//        }
//    }
//
////    @Override
////    public List<Restaurant> readAll() {
////        if(Collections.emptyList() != repo) {
////            return repo.findAll();
////        }else{
////            System.out.println("Error: Restaurant not found.");
////            return null;
////        }
////    }
//}
