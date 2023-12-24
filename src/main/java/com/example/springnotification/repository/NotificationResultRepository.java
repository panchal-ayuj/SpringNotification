package com.example.springnotification.repository;

import com.example.springnotification.NotificationResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationResultRepository extends JpaRepository<NotificationResult, Long> {
    // Add custom queries if needed
}
