package com.citypass.NotificationService;




import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    private final List<Notification> notifications = new ArrayList<>();

    public void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public List<Notification> getNotificationsForRider(String riderId) {
        return notifications.stream()
                .filter(n -> n.getRiderId().equals(riderId))
                .collect(Collectors.toList());
    }
}
