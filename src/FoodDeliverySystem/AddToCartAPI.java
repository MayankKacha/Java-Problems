package FoodDeliverySystem;

import FoodDeliverySystem.datalayer.FoodItemsDB;
import FoodDeliverySystem.factory.PermissionFactory;
import FoodDeliverySystem.managers.CartManager;
import FoodDeliverySystem.managers.UserManager;
import FoodDeliverySystem.models.CartItem;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.User;
import FoodDeliverySystem.permission.IPermission;
import FoodDeliverySystem.searcher.FoodItemSearchWithID;
import FoodDeliverySystem.searcher.ISearcher;

import java.util.ArrayList;
import java.util.List;

public class AddToCartAPI {

    private UserManager userManager = new UserManager();
    private ISearcher<FoodItem> foodItemISearcher;
    private CartManager cartManager = new CartManager();
    public List<CartItem> GetUserCart(User user){
        return new ArrayList<>();
    }
    //AddCart
    public void AddItemToCart(String authToken, int foodID){
        if (authToken == null || authToken.isEmpty()){
            throw new IllegalArgumentException("User auth token is  empty");
        }
        User user = userManager.GetUserByToken(authToken);
        if (user == null)
            throw new IllegalArgumentException("User not found!");

        foodItemISearcher = new FoodItemSearchWithID(foodID, new FoodItemsDB());
        List<FoodItem> foodItems = foodItemISearcher.search();
        if (foodItems != null && !foodItems.isEmpty()){
            cartManager.AddItemToCart(user, foodItems.get(0));
        }
    }
    public void DeleteCart(User user, FoodItem foodItem){

    }
    public void CheckOutUserCart(User user){

    }
}
