package DesingParkingLot.factory;

import DesingParkingLot.data.CardDetails;
import DesingParkingLot.payments.CardPaymentProcessor;
import DesingParkingLot.payments.CashPaymentProcessor;
import DesingParkingLot.payments.PaymentProcessor;

public class PaymentProcessorFactory {

    private PaymentProcessorFactory() {}

    public static PaymentProcessor getCardBasedPaymentProcessor(double amount, CardDetails cardDetails){
        return new CardPaymentProcessor(amount, cardDetails);
    }

    public static PaymentProcessor getCashBasedPaymentProcessor(double amount){
        return new CashPaymentProcessor(amount);
    }

}
