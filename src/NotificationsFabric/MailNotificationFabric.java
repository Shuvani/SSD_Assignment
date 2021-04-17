package NotificationsFabric;

import RegisterNotifications.RegisterNotification;
import RegisterNotifications.EmailRegisterNotification;
import ContestSoonNotifications.ContestSoonNotification;
import ContestSoonNotifications.MailContestSoonNotification;
import WinnerNotifications.WinnerNotification;
import WinnerNotifications.MailWinnerNotification;

public class MailNotificationFabric implements NotificationsFabric {

    @Override
    public RegisterNotification createRegisterNotification() {
        RegisterNotification hello = new EmailRegisterNotification();
        return(hello);
    }

    @Override
    public ContestSoonNotification createContestSoonNotification() {
        ContestSoonNotification hello = new MailContestSoonNotification();
        return(hello);
    }

    @Override
    public WinnerNotification createWinnerNotification() {
        WinnerNotification hello = new MailWinnerNotification();
        return(hello);
    }

}
