package NotificationFabric;

import RegisterNotifications.RegisterNotification;
import ContestSoonNotifications.ContestSoonNotification;
import WinnerNotifications.WinnerNotification;

public interface NotificationFabric {
    public RegisterNotification createRegisterNotification();
    public ContestSoonNotification createContestSoonNotification();
    public WinnerNotification createWinnerNotification();
}
