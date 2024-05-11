package DependencyInversionPrinciple;

public class UPIPayment implements IPaymentProcessor
{
    @Override
    public void ProcessPayment(){
        System.out.println("UPI payment processed!");
    }
}
