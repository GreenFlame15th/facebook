package ripoff.facebook.notification.notification.sendNotification.application.details.notificationType.notificationChannel;

import ripoff.facebook.notification.notification.sendNotification.application.Notification;
import ripoff.facebook.notification.notification.sendNotification.application.details.NotificationParameters;

public class MobileAppNotification implements Notification {
    @Override
    public void notify(NotificationParameters parameters) {
        System.out.println("mobile app notification");
    }

    @Override
    public void setDestination(String destination) {

    }
}
