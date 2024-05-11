package FoodDeliverySystem.filters;

import FoodDeliverySystem.models.CuisineType;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.Restaurant;

import java.util.List;

public class CuisineFilter implements IFoodItemFilter , IRestaurantFilter{
    private List<CuisineType> cuisineType;

    public CuisineFilter(List<CuisineType> cuisineType) {
        this.cuisineType = cuisineType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return cuisineType.contains(foodItem.getCuisineType());
    }

    @Override
    public boolean search(Restaurant restaurant) {
        List<CuisineType> cuisineTypes = restaurant.getCuisineTypes();
        for (CuisineType cuisineType : cuisineTypes){
            if (this.cuisineType.contains(cuisineType)){
                return true;
            }
        }
        return false;
    }
}
