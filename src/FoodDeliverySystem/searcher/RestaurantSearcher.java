package FoodDeliverySystem.searcher;

import FoodDeliverySystem.datalayer.IFoodItemDataLayer;
import FoodDeliverySystem.datalayer.IRestaurantDataLayer;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantSearcher implements ISearcher<Restaurant> {
    private String name;
    private IRestaurantDataLayer restaurantDataLayer;
    public RestaurantSearcher(String name, IRestaurantDataLayer restaurantDataLayer){
        this.name = name;
        this.restaurantDataLayer = restaurantDataLayer;
    }
    @Override
    public List<Restaurant> search() {
        List<Restaurant> restaurants = restaurantDataLayer.GetAllRestaurants();
        return restaurants.stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
    }

}
