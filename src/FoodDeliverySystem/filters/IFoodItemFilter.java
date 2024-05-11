package FoodDeliverySystem.filters;

import FoodDeliverySystem.models.FoodItem;

public interface IFoodItemFilter {
    boolean filter(FoodItem foodItem);
}
