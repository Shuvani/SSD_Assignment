package ContestSoonNotifications;

public class SMSContestSoonNotification implements ContestSoonNotification{
    @Override
    public void sendNotification() {
        System.out.println(
                "Please, be informed that new contest will start in a week" +
                " - for details see the link https://suspicious-contest/new-contest"
        );
    }
}
