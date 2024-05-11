package DependencyInversionPrinciple;

public class EmailNotification implements INotificationSender
{
    @Override
    public void SendNotification(){
        System.out.println("Email sent!");
    }
}
