import RegisterNotifications.RegisterNotification;
import NotificationsFabric.NotificationsFabric;

public class Application {

    private NotificationsFabric fabric;
    private RegisterNotification registerNotification;

    public Application(NotificationsFabric fabric) {
        this.fabric = fabric;
    }

    public void createNotification() {
        this.registerNotification = fabric.createRegisterNotification();
    }

    public void sendNotification() {
        registerNotification.sendNotification();
    }

}
