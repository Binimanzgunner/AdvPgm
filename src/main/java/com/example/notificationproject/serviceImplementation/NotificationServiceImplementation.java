package com.example.notificationproject.serviceImplementation;

import com.example.notificationproject.model.Employee;
import com.example.notificationproject.model.Notification;
import com.example.notificationproject.repository.EmployeeRepository;
import com.example.notificationproject.repository.NotificationRepository;
import com.example.notificationproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("NotificationService")
public class NotificationServiceImplementation implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;
    @Override
    public List<Notification> findAll() {
        return notificationRepository.findAll();
    }

    @Override
    public Notification findById(Long id) {
        Optional<Notification> optionalNotification=notificationRepository.findById(id);
        return optionalNotification.orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        notificationRepository.deleteById(id);

    }

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }
}
