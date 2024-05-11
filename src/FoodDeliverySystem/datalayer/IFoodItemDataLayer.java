package FoodDeliverySystem.datalayer;

import FoodDeliverySystem.models.FoodItem;

import java.util.List;

public interface IFoodItemDataLayer {
    // we can load only where isActive is true
    List<FoodItem> GetAllFoodItems();
}
