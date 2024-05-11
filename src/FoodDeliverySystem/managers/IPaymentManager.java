package FoodDeliverySystem.managers;

import FoodDeliverySystem.models.PaymentResponse;

// as we can have multiple payment types like card, UPI, net banking etc.
public interface IPaymentManager {
    PaymentResponse executePayment();
}
