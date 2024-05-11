package DependencyInversionPrinciple;

public class PurchaseFlowManager {
    private final INotificationSender notificationSender;
    private final IPaymentProcessor paymentProcessor;

    public PurchaseFlowManager(INotificationSender notificationSender, IPaymentProcessor paymentProcessor) {
        this.notificationSender = notificationSender;
        this.paymentProcessor = paymentProcessor;
    }

    public void triggerPurchaseFlow(){
        paymentProcessor.ProcessPayment();
        notificationSender.SendNotification();
    }

}
