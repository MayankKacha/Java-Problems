package DependencyInversionPrinciple;

public class SMSNotification implements INotificationSender
{
    @Override
    public void SendNotification() {
        System.out.println("SMS Sent!");
    }
}
