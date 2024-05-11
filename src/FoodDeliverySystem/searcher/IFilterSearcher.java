package FoodDeliverySystem.searcher;

import FoodDeliverySystem.filters.IFoodItemFilter;

import java.util.List;

public interface IFilterSearcher<T> {
    List<T> search(List<IFoodItemFilter> foodItemFilters);
}
