package org.francesco.demo.services;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendConfirmation(String orderId) {
        System.out.println("Conferma inviata per ordine: " + orderId);
    }
}
