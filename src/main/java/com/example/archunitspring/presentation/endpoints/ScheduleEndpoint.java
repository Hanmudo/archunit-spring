package com.example.archunitspring.presentation.endpoints;

import com.example.archunitspring.application.interfaces.ScheduleService;
import com.example.archunitspring.application.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleEndpoint {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleEndpoint(final ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping("/schedule/plane")
    public Schedule getPlaneTicketCount() {
        return scheduleService.getScheduleByType("Plane");
    }
}
