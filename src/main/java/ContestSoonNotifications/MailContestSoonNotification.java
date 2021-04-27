package ContestSoonNotifications;

public class MailContestSoonNotification implements ContestSoonNotification{
    @Override
    public void sendNotification() {
        System.out.println(
                "Please, be informed that new contest will start in a week" +
                " - for details send \"CONTEST\" to +79171111111"
        );
    }
}
