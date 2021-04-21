import NotificationFabric.NotificationFabric;
import NotificationFabric.SMSNotificationFabric;
import NotificationFabric.MailNotificationFabric;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import Users.*;
import Contest.*;
import javax.naming.OperationNotSupportedException;
import java.io.FileInputStream;
import java.util.Date;

public class ApplicationConfigurator {

    private static void testNotifications() throws OperationNotSupportedException{
        String notificationType = "SMS";
        NotificationFabric fabric;

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
