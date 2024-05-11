package FoodDeliverySystem.filters;

import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.MealType;
import FoodDeliverySystem.models.Restaurant;

public class MealTypeFilter implements IFoodItemFilter , IRestaurantFilter{
    private MealType mealType;

    public MealTypeFilter(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean filter(FoodItem foodItem) {
        return foodItem.getMealType().equals(mealType);
    }

    @Override
    public boolean search(Restaurant restaurant) {
        return restaurant.getMealType().equals(mealType);
    }
}
