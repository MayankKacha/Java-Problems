package DesingParkingLot.payments;

public class CashPaymentProcessor implements PaymentProcessor{

    public CashPaymentProcessor(double amount) {
        this.amount = amount;
    }

    private final double amount;

    @Override
    public boolean executePayment() {
        return false;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
