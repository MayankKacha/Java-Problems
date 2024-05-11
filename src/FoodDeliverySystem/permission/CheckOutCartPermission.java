package FoodDeliverySystem.permission;

import FoodDeliverySystem.models.User;

public class CheckOutCartPermission implements IPermission{

    public CheckOutCartPermission(User user) {
        this.user = user;
    }

    private final User user;

    @Override
    public boolean isPermitted() {
        return true;
    }
}
