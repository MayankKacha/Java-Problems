package FoodDeliverySystem.filters;

import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.Restaurant;
import FoodDeliverySystem.models.StarRatings;

public class RatingsFilter implements IFoodItemFilter , IRestaurantFilter{
    private StarRatings ratings;
    public RatingsFilter(StarRatings ratings) {
        this.ratings = ratings;
    }
    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getRatings().getVal() >= ratings.getVal();
    }

    @Override
    public boolean search(Restaurant restaurant) {
        return restaurant.getRatings().getVal() >= ratings.getVal();
    }
}
