package FoodDeliverySystem.searcher;

import FoodDeliverySystem.datalayer.IFoodItemDataLayer;
import FoodDeliverySystem.filters.IFoodItemFilter;
import FoodDeliverySystem.models.Filters;
import FoodDeliverySystem.models.FoodItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodItemSearcher implements IFilterSearcher<FoodItem>{
    private String name;
    private IFoodItemDataLayer foodItemDataLayer;
    public FoodItemSearcher(String name, IFoodItemDataLayer foodItemDataLayer){
        this.name = name;
        this.foodItemDataLayer = foodItemDataLayer;
    }
    @Override
    public List<FoodItem> search(List<IFoodItemFilter> foodItemFilters) {
        List<FoodItem> foodItems = foodItemDataLayer.GetAllFoodItems();
        List<FoodItem> filteredFoodItems = new ArrayList<>();
        if (foodItems != null && !foodItems.isEmpty()){
            filteredFoodItems = foodItems.stream().filter(x -> x.getName().contains(name)).collect(Collectors.toList());
        }
        filteredFoodItems = FilterFoodItems(filteredFoodItems, foodItemFilters);
        return filteredFoodItems;
    }

    private List<FoodItem> FilterFoodItems(List<FoodItem> foodItems, List<IFoodItemFilter> foodItemFilters){
        List<FoodItem> filteredFoodItems = foodItems;
        for (IFoodItemFilter foodItemFilter : foodItemFilters){
            List<FoodItem> filteredItems = new ArrayList<>();
            for(FoodItem foodItem : filteredFoodItems){
                if (foodItemFilter.filter(foodItem)){
                    filteredItems.add(foodItem);
                }
            }
            filteredFoodItems = filteredItems;
        }
        return filteredFoodItems;
    }
}
