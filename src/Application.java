import RegisterNotifications.RegisterNotification;
import NotificationFabric.NotificationFabric;

public class Application {

    private NotificationFabric fabric;
    private RegisterNotification registerNotification;

    public Application(NotificationFabric fabric) {
        this.fabric = fabric;
    }

    public void createNotification() {
        this.registerNotification = fabric.createRegisterNotification();
    }

    public void sendNotification() {
        registerNotification.sendNotification();
    }

}
