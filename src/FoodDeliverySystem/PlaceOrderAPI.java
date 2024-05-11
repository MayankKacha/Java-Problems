package FoodDeliverySystem;

import FoodDeliverySystem.datalayer.UsersDB;
import FoodDeliverySystem.factory.PaymentManagerFactory;
import FoodDeliverySystem.managers.IPaymentManager;
import FoodDeliverySystem.managers.OrderManager;
import FoodDeliverySystem.managers.UserManager;
import FoodDeliverySystem.models.Order;
import FoodDeliverySystem.models.PaymentResponse;
import FoodDeliverySystem.models.User;

import java.util.Map;

public class PlaceOrderAPI {
    private final UserManager userManager = new UserManager();
    private final OrderManager orderManager = new OrderManager();
    public Order PlaceOrder(String userToken, Map<String,String> paymentInfo, String paymentMode){
        if (userToken == null || userToken.isEmpty()){
            throw new IllegalArgumentException("Params missing!");
        }
        User user = userManager.GetUserByToken(userToken);
        if (user == null || !user.isActive()){
            throw new IllegalArgumentException("User is not active");
        }
        // below is factory design patter helps to achieve abstract as in below, user need not know about available payment options, entity will handle
        IPaymentManager paymentManager = PaymentManagerFactory.GetPaymentManager(paymentMode, paymentInfo);
        PaymentResponse paymentResponse = paymentManager.executePayment();
        if (paymentResponse == null || paymentResponse.getPaymentStatus() == null || paymentResponse.getPaymentStatus().equals("Failed")){
            throw new IllegalArgumentException("Payment Failed!");
        }
        return orderManager.PlaceOrder(user);
    }

}
