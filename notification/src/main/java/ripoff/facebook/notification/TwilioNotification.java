package ripoff.facebook.notification;

import ripoff.facebook.notification.dto.NotificationParameters;

public class TwilioNotification implements Notification{

    private String phoneNumber;

    @Override
    public void notify(NotificationParameters parameters) {
        System.out.println("sending twilio notification to number: " + phoneNumber);
    }

    @Override
    public void setDestination(String destination) {
        this.phoneNumber = destination;
    }
}