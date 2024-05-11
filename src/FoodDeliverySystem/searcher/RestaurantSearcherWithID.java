package FoodDeliverySystem.searcher;

import FoodDeliverySystem.datalayer.IRestaurantDataLayer;
import FoodDeliverySystem.models.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantSearcherWithID implements ISearcher<Restaurant>{
    private int id;
    private IRestaurantDataLayer restaurantDataLayer;

    public RestaurantSearcherWithID(int id, IRestaurantDataLayer restaurantDataLayer) {
        this.id = id;
        this.restaurantDataLayer = restaurantDataLayer;
    }

    @Override
    public List<Restaurant> search() {
        List<Restaurant> restaurants = restaurantDataLayer.GetAllRestaurants();
        return restaurants.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
    }
}
