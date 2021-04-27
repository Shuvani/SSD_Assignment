package RegisterNotifications;

public class MailRegisterNotification implements RegisterNotification{
    @Override
    public void sendNotification() {
        System.out.println("To confirm contest registration click the link https://suspicious-contest/main-page");
    }
}