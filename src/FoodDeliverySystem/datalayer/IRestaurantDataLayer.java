package FoodDeliverySystem.datalayer;

import FoodDeliverySystem.models.Restaurant;

import java.util.List;

public interface IRestaurantDataLayer {
    List<Restaurant> GetAllRestaurants();
}
