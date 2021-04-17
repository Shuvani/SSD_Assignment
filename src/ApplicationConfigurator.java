import NotificationsFabric.NotificationsFabric;
import NotificationsFabric.SMSNotificationFabric;
import NotificationsFabric.MailNotificationFabric;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.naming.OperationNotSupportedException;

public class ApplicationConfigurator {

    public static void main(String[] args) throws OperationNotSupportedException {
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

}
