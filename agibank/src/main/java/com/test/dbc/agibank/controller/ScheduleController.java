package com.test.dbc.agibank.controller;

import com.test.dbc.agibank.business.interfaces.IScheduleBO;
import com.test.dbc.agibank.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/schedule")
public class ScheduleController {

    @Autowired
    private IScheduleBO scheduleBO;

    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return scheduleBO.createSchedule(schedule);
    }

}
