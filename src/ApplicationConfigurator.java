import NotificationsFabric.NotificationsFabric;
import NotificationsFabric.SMSNotificationFabric;
import NotificationsFabric.MailNotificationFabric;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import Contest.Contest;
import javax.naming.OperationNotSupportedException;
import java.util.Date;

public class ApplicationConfigurator {

    private static void testNotifications() throws OperationNotSupportedException{
        String notificationType = "SMS";
        NotificationsFabric fabric;

        if (notificationType == "SMS") {
            fabric = new SMSNotificationFabric();
        }
        else if (notificationType == "Mail") {
            fabric = new MailNotificationFabric();
        }
        else {
            throw new OperationNotSupportedException();
        }

        Application app = new Application(fabric);
        app.createNotification();
        app.sendNotification();
    }

    private static void testContest(){
        Date start = new Date(((2021-1970)*365+60)*24*60*60);
        Date end = new Date(((2022-1970)*365+60)*24*60*60);
        Contest contest = new Contest("Red", "Contest of colorful photos", start, end);
//        contest.finish();
    }

    public static void main(String[] args) throws OperationNotSupportedException {
        testNotifications();
        testContest();
    }

}
