package com.example.notificationproject.service;

import com.example.notificationproject.model.Employee;
import com.example.notificationproject.model.Notification;

import java.util.List;


public interface NotificationService {
    public abstract List<Notification> findAll();
    public abstract Notification findById(Long id);
    public abstract void deleteById(Long id);
    public abstract Notification save(Notification notification);
}
