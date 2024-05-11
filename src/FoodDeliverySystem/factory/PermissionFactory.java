package FoodDeliverySystem.factory;


import FoodDeliverySystem.models.FoodItem;
import FoodDeliverySystem.models.Order;
import FoodDeliverySystem.models.OrderStatus;
import FoodDeliverySystem.models.User;
import FoodDeliverySystem.permission.*;

// Permission factory will interact with interface permission, all methods will be static with private constructor of class.
public class PermissionFactory {

    private PermissionFactory() {}

    public static IPermission GetUpdateCartPermission(User user, Order order, OrderStatus orderStatus){
        return new UpdateOrderPermission(user,order,orderStatus);
    }

    public static IPermission GetAddToCartPermission(User user, FoodItem foodItem){
        return new AddToCartPermission(user,foodItem);
    }

    public static IPermission GetDeleteToCartPermission(User user, FoodItem foodItem){
        return new AddToCartPermission(user,foodItem);
    }

    public static IPermission GetCheckoutCartPermission(User user){
        return new CheckOutCartPermission(user);
    }

    public static IPermission GetPlaceOrderPermission(User user){
        return new PlaceOrderPermission(user);
    }

    public static IPermission GetUpdateOrderPermission(User user, Order order, OrderStatus orderStatus){
        return new UpdateOrderPermission(user,order,orderStatus);
    }

}
