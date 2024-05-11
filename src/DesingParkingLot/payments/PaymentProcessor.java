package DesingParkingLot.payments;

public interface PaymentProcessor {

    boolean executePayment();

    double getAmount();

}
