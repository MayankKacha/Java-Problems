package FoodDeliverySystem.filters;

import FoodDeliverySystem.models.Restaurant;

public interface IRestaurantFilter {
    boolean search(Restaurant restaurant);
}
