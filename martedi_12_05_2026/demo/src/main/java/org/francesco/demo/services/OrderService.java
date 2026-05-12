package org.francesco.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private NotificationService notificationService;

    // @Autowired
    // public void setNotificationService(NotificationService notificationService) {
    // this.notificationService = notificationService;
    // }

    // public OrderService(NotificationService notificationService) {
    // this.notificationService = notificationService;
    // }

    public void processOrder(String orderId) {
        notificationService.sendConfirmation(orderId);
    }
}
