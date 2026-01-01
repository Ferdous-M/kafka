package com.citypass.NotificationService;




import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/notifications/{riderId}")
    public List<Notification> getNotifications(@PathVariable String riderId) {
        return notificationService.getNotificationsForRider(riderId);
    }
}
