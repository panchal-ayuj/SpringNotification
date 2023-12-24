package com.example.springnotification.service;

import com.example.springnotification.User;
import com.example.springnotification.UserNotification;
import com.example.springnotification.repository.UserNotificationRepository;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private UserNotificationRepository notificationRepository;

    @Autowired
    private VelocityEngine velocityEngine;

    public void generateAndSaveNotifications(List<User> users) {
        for (User user : users) {
            String message = generateNotificationMessage(user);
            UserNotification notification = new UserNotification();
            notification.setUser(user);
            notification.setMessage(message);
            notificationRepository.save(notification);
        }
    }

    private String generateNotificationMessage(User user) {
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("user", user);

        StringWriter writer = new StringWriter();
        velocityEngine.mergeTemplate("templates/notification.vm", "UTF-8", velocityContext, writer);

        return writer.toString();
    }
}

