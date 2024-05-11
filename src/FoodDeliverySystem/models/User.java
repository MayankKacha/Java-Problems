package FoodDeliverySystem.models;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String email;
    private boolean isActive;
    private List<CartItem> cartItems;
    private String authToken;
    private Address address;
    private String phoneNumber;

    public User(int id, String name, String email, boolean isActive, List<CartItem> cartItems, String authToken, Address address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isActive = isActive;
        this.cartItems = cartItems;
        this.authToken = authToken;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public String getAuthToken() {
        return authToken;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
