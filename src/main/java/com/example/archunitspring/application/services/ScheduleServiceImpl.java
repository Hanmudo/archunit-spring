package com.example.archunitspring.application.services;

import com.example.archunitspring.application.interfaces.ScheduleService;
import com.example.archunitspring.application.models.Schedule;
import com.example.archunitspring.application.models.ScheduleItem;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Override
    public Schedule getScheduleByType(final String type) {
        var scheduleItems = new ArrayList<ScheduleItem>();
        scheduleItems.add(new ScheduleItem("To Amsterdam", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), "Plane"));
        scheduleItems.add(new ScheduleItem("To Utrecht", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()), "Train"));
        var schedule = new Schedule(scheduleItems);
        return schedule;
    }

    @Override
    public void writeScheduleToFile(final ScheduleItem scheduleItem) throws Exception {
        File f = new File("persistentScheduleItem.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
        oos.writeObject(scheduleItem);
        oos.flush();
        oos.close();
    }
}
