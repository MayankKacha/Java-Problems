package FoodDeliverySystem.models;

public enum StarRatings {
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5);
    private int val;
    private StarRatings(int val){
        this.val = val;
    }
    public int getVal(){
        return this.val;
    }
}
