package com.example.notificationproject.repository;

import com.example.notificationproject.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("NotificationRepository")
public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
