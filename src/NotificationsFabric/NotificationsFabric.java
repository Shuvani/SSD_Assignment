package NotificationsFabric;

import RegisterNotifications.RegisterNotification;
import ContestSoonNotifications.ContestSoonNotification;
import WinnerNotifications.WinnerNotification;

public interface NotificationsFabric {
    public RegisterNotification createRegisterNotification();
    public ContestSoonNotification createContestSoonNotification();
    public WinnerNotification createWinnerNotification();
}
