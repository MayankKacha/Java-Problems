package FoodDeliverySystem.managers;

import FoodDeliverySystem.models.PaymentResponse;

public class NetBankingPaymentManager implements IPaymentManager{

    private final String bankName;
    private final String cardNumber;
    private final String pin;
    private final double amount;
    private final String userName;
    private final String password;

    public NetBankingPaymentManager(String bankName, String cardNumber, String pin, double amount, String userName,String password) {
        this.bankName = bankName;
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.amount = amount;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public PaymentResponse executePayment() {
        return null;
    }
}
