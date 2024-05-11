package FoodDeliverySystem.managers;

import FoodDeliverySystem.models.PaymentResponse;

public class CardBasedPaymentManager implements IPaymentManager{
    private final String bankName;
    private final String cardNumber;
    private final String pin;

    public CardBasedPaymentManager(String bankName, String cardNumber, String pin, double amount) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.amount = amount;
    }

    private final double amount;
    @Override
    public PaymentResponse executePayment() {
        return null;
    }
}
