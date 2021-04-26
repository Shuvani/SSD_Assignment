package WinnerNotifications;

public class SMSWinnerNotification implements WinnerNotification{
    @Override
    public void sendNotification() {
        System.out.println(
                "Congratulations, you are the winner! " +
                "To see the list of the best works and other info" +
                " - send \"RESULTS\" to +79171111111"
        );
    }
}
