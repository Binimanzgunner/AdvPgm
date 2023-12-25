package com.example.notificationproject.controller;

import com.example.notificationproject.model.Notification;
import com.example.notificationproject.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public class NotificationController {
    @Autowired
    private NotificationService notificationService;

    // new
    @RequestMapping(value = "/notification/new", method = RequestMethod.GET)
    public String notificationRegForm(Model model){
        model.addAttribute("notification", new Notification());
        return "notification/new";
    }

//    save

    @RequestMapping(value = "/notification/new", method = RequestMethod.POST)
    public String notificationNewSupplier(Model model, Notification notification){
        notification= notificationService.save(notification);
        model.addAttribute("notification", notification);
        return "redirect:/notification/list";
    }

//    list

    @RequestMapping(value = "/notification/list", method = RequestMethod.GET)
    public String findAllNotifications(Model model){
        List<Notification> notifications= notificationService.findAll();
        model.addAttribute("notification", notifications);
        return "notification/list";
    }

//    Delete

    @RequestMapping(value = "/notification/delete/{id}", method = RequestMethod.GET)
    public String deleteNotificationFromList(@PathVariable Long id){
        notificationService.deleteById(id);
        return "redirect:/notification/list";
    }
//    edit

    @RequestMapping(value = "/notification/edit/{id}", method = RequestMethod.GET)
    public String editNotification(Model model,@PathVariable Long id){
        Notification notification= notificationService.findById(id);
        model.addAttribute("notification", notification);
        return "notification/edit";
    }


    @RequestMapping(value = "/notification/edit", method = RequestMethod.POST)
    public String editedNotificationData(Notification notification){
        notificationService.save(notification);
        return "redirect:/notification/list";
    }
}
