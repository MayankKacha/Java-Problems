package FoodDeliverySystem.permission;

import FoodDeliverySystem.models.Order;
import FoodDeliverySystem.models.OrderStatus;
import FoodDeliverySystem.models.User;

// update when to cancel or something  like that
public class UpdateOrderPermission implements IPermission {
    private final User user;
    private final Order order;
    private final OrderStatus orderStatus;

    public UpdateOrderPermission(User user, Order order, OrderStatus orderStatus) {
        this.user = user;
        this.order = order;
        this.orderStatus = orderStatus;
    }


    @Override
    public boolean isPermitted() {
        return false;
    }
}
