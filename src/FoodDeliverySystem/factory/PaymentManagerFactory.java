package FoodDeliverySystem.factory;

import FoodDeliverySystem.managers.CardBasedPaymentManager;
import FoodDeliverySystem.managers.IPaymentManager;
import FoodDeliverySystem.managers.NetBankingPaymentManager;
import FoodDeliverySystem.models.PaymentMode;

import java.util.Map;
import java.util.Objects;

public class PaymentManagerFactory {

    private PaymentManagerFactory(){}

    public static IPaymentManager GetPaymentManager(String paymentMode, Map<String,String> paymentInfo){
        IPaymentManager paymentManager = null;
        if (Objects.equals(paymentMode, PaymentMode.NetBanking.toString())){
            return GetNetBankingPaymentInfo(paymentInfo);
        }
        else if (Objects.equals(paymentMode, PaymentMode.CardPayment.toString())){
            return GetCardPaymentManager(paymentInfo);
        }
        else
            throw new RuntimeException("Invalid payment mode!");
    }

    private static IPaymentManager GetNetBankingPaymentInfo(Map<String,String> paymentInfo){
        return new NetBankingPaymentManager(paymentInfo.get("bankName"), paymentInfo.get("cardNumber"),
                paymentInfo.get("pin"), Double.parseDouble(paymentInfo.get("amount")), paymentInfo.get("userName"), paymentInfo.get("password") );
    }

    private static IPaymentManager GetCardPaymentManager(Map<String,String> paymentInfo){
        return new CardBasedPaymentManager(paymentInfo.get("bankName"), paymentInfo.get("cardNumber"),
                paymentInfo.get("pin"), Double.parseDouble(paymentInfo.get("amount")));
    }

}
