import NotificationFabric.NotificationFabric;
import NotificationFabric.SMSNotificationFabric;
import NotificationFabric.MailNotificationFabric;

import javax.naming.OperationNotSupportedException;

public class ApplicationConfigurator {

    public static void main(String[] args) throws OperationNotSupportedException {
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

}
