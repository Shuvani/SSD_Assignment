package WinnerNotifications;

public class MailWinnerNotification implements WinnerNotification{
    @Override
    public void sendNotification() {
        System.out.println(
                "Congratulations, you are the winner! " +
                "To see the list of the best works and other info" +
                " - click the link https://suspicious-contest/results"
        );
    }
}
