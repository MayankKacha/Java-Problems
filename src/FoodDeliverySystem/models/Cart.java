package FoodDeliverySystem.models;

public class Cart {

    public final int cart_id;
    public final int user_id;
    public final int food_item_id;
    public final int quantity;

    public Cart(int cart_id, int user_id, int food_item_id, int quantity, boolean status) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.food_item_id = food_item_id;
        this.quantity = quantity;
        this.status = status;
    }

    public int getCart_id() {
        return cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getFood_item_id() {
        return food_item_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public final boolean status;

}
