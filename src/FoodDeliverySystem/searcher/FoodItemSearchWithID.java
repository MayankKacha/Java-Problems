package FoodDeliverySystem.searcher;

import FoodDeliverySystem.datalayer.IFoodItemDataLayer;
import FoodDeliverySystem.models.FoodItem;

import java.util.List;
import java.util.stream.Collectors;

public class FoodItemSearchWithID implements ISearcher<FoodItem> {
    private int id;
    private IFoodItemDataLayer foodItemDataLayer;
    public FoodItemSearchWithID(int id, IFoodItemDataLayer foodItemDataLayer){
        this.id = id;
        this.foodItemDataLayer = foodItemDataLayer;
    }
    @Override
    public List<FoodItem> search() {
        List<FoodItem> foodItems = foodItemDataLayer.GetAllFoodItems();
        return foodItems.stream().filter(x -> x.getId() == id).collect(Collectors.toList());
    }
}
