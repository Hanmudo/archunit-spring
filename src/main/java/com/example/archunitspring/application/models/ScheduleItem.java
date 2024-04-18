package com.example.archunitspring.application.models;

import java.util.Date;

public record ScheduleItem(String subject, Date start, Date arrival, String travelBy) {
}
