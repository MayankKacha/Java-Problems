package DependencyInversionPrinciple;

public class PurchaseFlowSimulator
{
    public static void main(String[] args){
        PurchaseFlowManager purchaseFlowManager;
        purchaseFlowManager = new PurchaseFlowManager(new EmailNotification(), new NetBankingPayment());
        purchaseFlowManager.triggerPurchaseFlow();
        System.out.println("----------");
        purchaseFlowManager = new PurchaseFlowManager(new SMSNotification(), new UPIPayment());
        purchaseFlowManager.triggerPurchaseFlow();
    }
}
