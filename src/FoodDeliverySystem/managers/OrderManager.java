package FoodDeliverySystem.managers;

import FoodDeliverySystem.datalayer.DataAccessor;
import FoodDeliverySystem.factory.PermissionFactory;
import FoodDeliverySystem.models.CartItem;
import FoodDeliverySystem.models.Order;
import FoodDeliverySystem.models.OrderStatus;
import FoodDeliverySystem.models.User;
import FoodDeliverySystem.permission.IPermission;

import java.util.List;

public class OrderManager {

    public Order PlaceOrder(User user){
        // here we will have place order logic
        if (user == null || !user.isActive()){
            throw new IllegalArgumentException("User invalid!");
        }
        IPermission permission = PermissionFactory.GetPlaceOrderPermission(user);
        if (permission == null || !permission.isPermitted()){
            throw new IllegalArgumentException("Permission not granted");
        }
        CartManager cartManager = new CartManager();
        List<CartItem> cartItems = cartManager.GetUserCart(user);
        String orderID = DataAccessor.CreateOrder(user, cartItems);
        cartManager.CheckOutUserCart(user);
        return new Order(orderID, OrderStatus.ORDER_PLACED , user.getId(), cartItems);
    }

    public List<Order> GetOrders(User user){
        return null;
    }

    public Order GetUserOrder(String orderId){
        return null;
    }

    // like below method others can be created like set order to out for delivery etc, checking authority of user as some status restaurant owners only can change and some can be changed by delivery
    // partner only.
    // we can use state design pattern on the case when some state is getting changes why to use? .> without it we will have multiple if else statements like we can reach to this state only if we come from
    // some specific state
    public void SetOrderToCooking(User user, Order order){
        if (user == null || !user.isActive()){
            throw new IllegalArgumentException("User invalid!");
        }
        IPermission permission = PermissionFactory.GetUpdateOrderPermission(user,order,OrderStatus.COOKING);
        if (permission == null || !permission.isPermitted()){
            throw new IllegalArgumentException("Permission not granted");
        }
        if (!order.getOrderStatus().equals(OrderStatus.ORDER_PLACED)){
            throw new IllegalArgumentException("cant move!");
        }
        DataAccessor.ChangeOrderStatus(order.getOrder_id(), OrderStatus.COOKING.toString());
    }


}
