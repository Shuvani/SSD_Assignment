package NotificationFabric;

import RegisterNotifications.RegisterNotification;
import RegisterNotifications.MailRegisterNotification;
import ContestSoonNotifications.ContestSoonNotification;
import ContestSoonNotifications.MailContestSoonNotification;
import WinnerNotifications.WinnerNotification;
import WinnerNotifications.MailWinnerNotification;

public class MailNotificationFabric implements NotificationFabric {

    @Override
    public RegisterNotification createRegisterNotification() {
        RegisterNotification hello = new MailRegisterNotification();
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
