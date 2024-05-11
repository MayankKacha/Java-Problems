package FoodDeliverySystem;

import FoodDeliverySystem.managers.OrderManager;
import FoodDeliverySystem.managers.UserManager;
import FoodDeliverySystem.models.Order;
import FoodDeliverySystem.models.OrderStatus;
import FoodDeliverySystem.models.User;

public class UpdateOrderAPI {
    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();
    public void UpdateOrder(String userToken, OrderStatus orderStatus, String orderID){
        if (userToken == null || userToken.isEmpty()){
            throw new IllegalArgumentException("Params missing!");
        }
        User user = userManager.GetUserByToken(userToken);
        if (user == null || !user.isActive()){
            throw new IllegalArgumentException("User is not active");
        }
        Order order = orderManager.GetUserOrder(orderID);
        if (order == null || order.getOrderStatus() == null){
            throw new IllegalArgumentException("Invalid order id!");
        }
        if (order.getOrderStatus().equals(OrderStatus.COOKING)){
            orderManager.SetOrderToCooking(user,order);
        }
    }

}
