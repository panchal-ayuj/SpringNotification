package com.example.springnotification;

import com.example.springnotification.repository.NotificationResultRepository;
import com.example.springnotification.repository.UserNotificationRepository;
import com.example.springnotification.repository.UserRepository;
import com.example.springnotification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotificationProcessor implements CommandLineRunner {

    @Autowired
    private UserNotificationRepository notificationRepository;

    @Autowired
    private NotificationResultRepository resultRepository;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // Fetch notifications from the database

        List<User> users = userRepository.findAll();

        notificationService.generateAndSaveNotifications(users);
        List<UserNotification> notifications = notificationRepository.findAll();

        // Process notifications and store results
        for (UserNotification notification : notifications) {
            String resultData = processNotification(notification);
            saveResult(notification.getUser(), resultData);
        }
    }

    private String processNotification(UserNotification notification) {
        return "Processed notification for user: " + notification.getUser().getName();
    }

    private void saveResult(User user, String resultData) {
        // Save the processed result to the separate table
        NotificationResult result = new NotificationResult();
        result.setUser(user);
        result.setResultData(resultData);
        resultRepository.save(result);
    }
}

