package FoodDeliverySystem.models;

import java.util.List;

public class Restaurant {
    private String name;
    private int id;
    private Address address;
    private List<FoodItem> availableFoodItems;
    private boolean isListed;
    private boolean isOpen;
    private StarRatings ratings;
    private List<CuisineType> cuisineTypes;
    private BusinessHours businessHours;
    private MealType mealType;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<FoodItem> getAvailableFoodItems() {
        return availableFoodItems;
    }

    public void setAvailableFoodItems(List<FoodItem> availableFoodItems) {
        this.availableFoodItems = availableFoodItems;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isListed() {
        return isListed;
    }

    public void setListed(boolean listed) {
        isListed = listed;
    }

    public StarRatings getRatings() {
        return ratings;
    }

    public void setRatings(StarRatings ratings) {
        this.ratings = ratings;
    }

    public List<CuisineType> getCuisineTypes() {
        return cuisineTypes;
    }

    public void setCuisineTypes(List<CuisineType> cuisineTypes) {
        this.cuisineTypes = cuisineTypes;
    }

    public BusinessHours getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(BusinessHours businessHours) {
        this.businessHours = businessHours;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }
}
