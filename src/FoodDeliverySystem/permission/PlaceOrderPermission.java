package FoodDeliverySystem.permission;

import FoodDeliverySystem.models.User;

public class PlaceOrderPermission implements IPermission {
    private final User user;

    public PlaceOrderPermission(User user) {
        this.user = user;
    }

    @Override
    public boolean isPermitted() {
        return false;
    }
}