package FoodDeliverySystem.datalayer;

import FoodDeliverySystem.models.CartItem;
import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.OrderStatus;
import FoodDeliverySystem.models.User;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

// We can create one data access converter class and method of this class will return Data access result and which can be converted to List<CartItems> in converter class.
public class DataAccessor {

    private DataAccessor() { }

    public static void AddItemToCart(User user, FoodItem foodItem){
        UsersDB usersDB = new UsersDB();
        List<CartItem> cartItems = usersDB.GetCartItems(user);
        List<CartItem> existingCartItem = cartItems.stream().filter(x -> Objects.equals(x.getFoodItem().getName(), foodItem.getName())).toList();
        CartItem cartItem;
        if (existingCartItem.isEmpty()){
            cartItem = new CartItem(foodItem,1);
        }
        else{
            int quantity = existingCartItem.get(0).getQuantity();
            cartItem = new CartItem(foodItem, quantity+1);
        }
        cartItems.add(cartItem);
        usersDB.UpdateCart(cartItems);
    }

    public static void DeleteFromCart(User user, FoodItem foodItem){
        UsersDB usersDB = new UsersDB();
        List<CartItem> cartItems = usersDB.GetCartItems(user);
        List<CartItem> existingCartItem = cartItems.stream().filter(x -> Objects.equals(x.getFoodItem().getName(), foodItem.getName())).toList();
        CartItem cartItem;
        if (existingCartItem.isEmpty()){
            throw new IllegalArgumentException("Cart item not available!");
        }
        else{
            int quantity = existingCartItem.get(0).getQuantity();
            cartItem = new CartItem(foodItem,  quantity == 0 ? 0 : quantity -1);
        }
        cartItems.add(cartItem);
        usersDB.UpdateCart(cartItems);
    }

    public static void CheckOutCart(User user){

    }

    public static void ChangeOrderStatus(String orderID, String orderStatus){

    }

    public static String CreateOrder(User user, List<CartItem> cartItems){
        return UUID.randomUUID().toString();
    }

}
