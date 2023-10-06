package com.test.dbc.agibank.business;

import com.test.dbc.agibank.business.interfaces.IScheduleBO;
import com.test.dbc.agibank.models.Schedule;
import com.test.dbc.agibank.repositories.ScheduleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
@Slf4j
public class ScheduleBO implements IScheduleBO {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Schedule createSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule findByUuid (String uuid) {
        return scheduleRepository.findByUuid(uuid);
    }
}
