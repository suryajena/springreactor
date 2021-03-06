package org.surya.service.impl;

import org.springframework.stereotype.Service;
import org.surya.doman.NotificationData;
import org.surya.service.NotificationService;

@Service
public class NotificationServiceimpl implements NotificationService {

    @Override
    public void initiateNotification(NotificationData notificationData) throws InterruptedException {

        System.out.println("Notification service started for Notification ID: " + notificationData.getId());

        Thread.sleep(5000);

        System.out.println("Notification service ended for Notification ID: " + notificationData.getId());
    }

}
