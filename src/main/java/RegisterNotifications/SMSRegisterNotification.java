package RegisterNotifications;

public class SMSRegisterNotification implements RegisterNotification{
    @Override
    public void sendNotification() {
        System.out.println("To confirm contest registration send \"CONFIRM\" to +79171111111");
    }
}
