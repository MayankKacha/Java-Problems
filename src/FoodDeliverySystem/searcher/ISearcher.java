package FoodDeliverySystem.searcher;

import FoodDeliverySystem.filters.IFoodItemFilter;

import java.util.List;

public interface ISearcher<T> {
    List<T> search();
}
