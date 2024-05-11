package FoodDeliverySystem.managers;

import FoodDeliverySystem.datalayer.DataAccessor;
import FoodDeliverySystem.datalayer.UsersDB;
import FoodDeliverySystem.factory.PermissionFactory;
import FoodDeliverySystem.models.CartItem;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.User;
import FoodDeliverySystem.permission.IPermission;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartManager {

    private final UsersDB usersDB;
    public CartManager(){
        usersDB = new UsersDB();
    }

    public List<CartItem> GetUserCart(User user){
        return usersDB.GetCartItems(user);
    }

    public void AddItemToCart(User user, FoodItem foodItem){
        if (user.getAuthToken() == null || user.getAuthToken().isEmpty() || !user.isActive() || foodItem == null){
            throw new IllegalArgumentException("Invalid request!");
        }
        IPermission permission = PermissionFactory.GetAddToCartPermission(user,foodItem);
        if (!permission.isPermitted())
            throw new IllegalArgumentException("No permission to add to cart!");
        if (!isFoodItemFromSameRestaurant(user,foodItem))
            throw new IllegalArgumentException("Different restaurant food item exists");
        DataAccessor.AddItemToCart(user,foodItem);
    }
    public void DeleteCart(User user, FoodItem foodItem){
        if (user.getAuthToken() == null || user.getAuthToken().isEmpty() || !user.isActive() || foodItem == null){
            throw new IllegalArgumentException("Invalid request!");
        }
        IPermission permission = PermissionFactory.GetDeleteToCartPermission(user,foodItem);
        if (!permission.isPermitted())
            throw new IllegalArgumentException("No permission to delete from cart!");
        if (!isFoodItemPresentInCart(user,foodItem))
            throw new IllegalArgumentException("Different restaurant food item exists");
        DataAccessor.DeleteFromCart(user,foodItem);
    }
    public void CheckOutUserCart(User user){
        if (user.getAuthToken() == null || user.getAuthToken().isEmpty() || !user.isActive()){
            throw new IllegalArgumentException("Invalid request!");
        }
        IPermission permission = PermissionFactory.GetCheckoutCartPermission(user);
        if (!permission.isPermitted())
            throw new IllegalArgumentException("No permission to delete from cart!");
        if (isCartEmpty(user))
            throw new IllegalArgumentException("Cart is empty!");
        DataAccessor.CheckOutCart(user);
    }

    private boolean isFoodItemFromSameRestaurant(User user, FoodItem foodItem){
        List<CartItem> cartItems = GetUserCart(user);
        return cartItems.isEmpty() || (cartItems.get(0).getFoodItem().getRestaurantId() == foodItem.getRestaurantId());
    }

    private boolean isFoodItemPresentInCart(User user, FoodItem foodItem){
        List<CartItem> cartItems = GetUserCart(user);
        return !cartItems.isEmpty() && !cartItems.stream().filter(x -> x.getFoodItem().getId() == foodItem.getId()).toList().isEmpty();
    }

    private boolean isCartEmpty(User user){
        return user.getCartItems().isEmpty();
    }

}
