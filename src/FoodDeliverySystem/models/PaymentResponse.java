package FoodDeliverySystem.models;

public class PaymentResponse {

    private final int id;
    private final double amount;

    public PaymentResponse(int id, double amount, PaymentStatus paymentStatus) {
        this.id = id;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    private final PaymentStatus paymentStatus;


}
