package DesingParkingLot.payments;

import DesingParkingLot.data.CardDetails;

import java.util.Map;

public class CardPaymentProcessor implements PaymentProcessor{

    private final double amount;

    public CardPaymentProcessor(double amount, CardDetails cardDetails) {
        this.amount = amount;
        this.cardDetails = cardDetails;
    }

    private final CardDetails cardDetails;

    @Override
    public boolean executePayment() {
        return false;
    }

    @Override
    public double getAmount() {
        return this.amount;
    }
}
