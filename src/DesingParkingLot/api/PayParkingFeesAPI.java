package DesingParkingLot.api;

import DesingParkingLot.data.CardDetails;
import DesingParkingLot.data.PaymentMode;
import DesingParkingLot.data.Ticket;
import DesingParkingLot.factory.PaymentProcessorFactory;
import DesingParkingLot.payments.CardPaymentProcessor;
import DesingParkingLot.payments.CashPaymentProcessor;
import DesingParkingLot.payments.ParkingFeeProcessor;
import DesingParkingLot.payments.PaymentProcessor;

import java.util.Map;

public class PayParkingFeesAPI {

    public boolean payParkingFees(Ticket ticket, PaymentMode paymentMode, Map<String, String> paymentDetails){
        PaymentProcessor paymentProcessor = null;
        double amount = Double.parseDouble(paymentDetails.get("amount"));
        if (paymentMode.equals(PaymentMode.CARD)){
            paymentProcessor = PaymentProcessorFactory.getCardBasedPaymentProcessor(amount,null);
        }else if (paymentMode.equals(PaymentMode.CASH)){
            paymentProcessor = PaymentProcessorFactory.getCashBasedPaymentProcessor(amount);
        }else {
            throw new IllegalArgumentException("Illegal payment type chosen");
        }
        return new ParkingFeeProcessor().processParkingFees(ticket,paymentProcessor);
    }

}
