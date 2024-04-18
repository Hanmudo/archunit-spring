package com.example.archunitspring.application.interfaces;

import com.example.archunitspring.application.models.Schedule;
import com.example.archunitspring.application.models.ScheduleItem;

public interface ScheduleService {
    Schedule getScheduleByType(final String type);
    void writeScheduleToFile(final ScheduleItem scheduleItem) throws Exception;
}
