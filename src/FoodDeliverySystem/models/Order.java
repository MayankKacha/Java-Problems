package FoodDeliverySystem.models;

import java.util.List;

public class Order {

    public final String order_id;

    public final OrderStatus orderStatus;
    public final int userID;
    public final List<CartItem> cartItems;

    public Order(String order_id, OrderStatus orderStatus,int userID, List<CartItem> cartItems) {
        this.order_id = order_id;
        this.orderStatus = orderStatus;
        this.userID = userID;
        this.cartItems = cartItems;
    }

    public int getUserID() {
        return userID;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
    public String getOrder_id() {
        return order_id;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

}
