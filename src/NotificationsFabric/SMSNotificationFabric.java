package NotificationsFabric;

import RegisterNotifications.RegisterNotification;
import RegisterNotifications.SMSRegisterNotification;
import ContestSoonNotifications.ContestSoonNotification;
import ContestSoonNotifications.SMSContestSoonNotification;
import WinnerNotifications.WinnerNotification;
import WinnerNotifications.SMSWinnerNotification;

public class SMSNotificationFabric implements NotificationsFabric {

    @Override
    public RegisterNotification createRegisterNotification() {
        RegisterNotification registerMessage = new SMSRegisterNotification();
        return(registerMessage);
    }

    @Override
    public ContestSoonNotification createContestSoonNotification() {
        ContestSoonNotification contestSoonMessage = new SMSContestSoonNotification();
        return(contestSoonMessage);
    }

    @Override
    public WinnerNotification createWinnerNotification() {
        WinnerNotification winnerMessage = new SMSWinnerNotification();
        return(winnerMessage);
    }

}
