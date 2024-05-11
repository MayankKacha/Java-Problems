package FoodDeliverySystem.permission;

import FoodDeliverySystem.datalayer.RestaurantDataLayer;
import FoodDeliverySystem.managers.DeliveryManager;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.Restaurant;
import FoodDeliverySystem.models.User;
import FoodDeliverySystem.searcher.RestaurantSearcherWithID;
// can help us in if food item is not available or user is not active
public class AddToCartPermission implements IPermission {
    private final User user;
    private final FoodItem foodItem;
    private final DeliveryManager deliveryManager;

    public AddToCartPermission(User user, FoodItem foodItem) {
        this.user = user;
        this.foodItem = foodItem;
        this.deliveryManager = new DeliveryManager();
    }

    @Override
    public boolean isPermitted() {

        if (!user.isActive() || !foodItem.isAvailable())
            return false;
        // check if users distance is in permissible area
        Restaurant restaurant = new RestaurantSearcherWithID(foodItem.getRestaurantId(), new RestaurantDataLayer()).search().get(0);
        if (deliveryManager.isDeliveryPossible(user.getAddress(), restaurant.getAddress())){
            return true;
        }
        return false;
    }
}
