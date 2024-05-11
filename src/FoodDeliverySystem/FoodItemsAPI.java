package FoodDeliverySystem;

import FoodDeliverySystem.datalayer.FoodItemsDB;
import FoodDeliverySystem.filters.CuisineFilter;
import FoodDeliverySystem.filters.IFoodItemFilter;
import FoodDeliverySystem.filters.MealTypeFilter;
import FoodDeliverySystem.filters.RatingsFilter;
import FoodDeliverySystem.models.CuisineType;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.MealType;
import FoodDeliverySystem.models.StarRatings;
import FoodDeliverySystem.searcher.FoodItemSearcher;

import java.util.ArrayList;
import java.util.List;

public class FoodItemsAPI {

    public List<FoodItem> SearchFoodItems(String name, MealType mealType, List<CuisineType> cuisineType, StarRatings ratings){
        if (name != null && !name.isEmpty()){
            List<IFoodItemFilter> foodItemFilters = new ArrayList<>();
            if (mealType != null){
                foodItemFilters.add(new MealTypeFilter(mealType));
            }
            if (cuisineType != null){
                foodItemFilters.add(new CuisineFilter(cuisineType));
            }
            if (ratings != null){
                foodItemFilters.add(new RatingsFilter(ratings));
            }
            return new FoodItemSearcher(name, new FoodItemsDB()).search(foodItemFilters);
        }
        return new ArrayList<>();
    }
}
