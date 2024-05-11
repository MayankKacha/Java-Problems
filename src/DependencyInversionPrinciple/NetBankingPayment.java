package DependencyInversionPrinciple;

public class NetBankingPayment implements IPaymentProcessor
{
    @Override
    public void ProcessPayment() {
        System.out.println("Payment Processed via netbanking!");
    }
}
