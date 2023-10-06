package com.test.dbc.agibank.business.interfaces;

import com.test.dbc.agibank.models.Schedule;

public interface IScheduleBO {

    Schedule createSchedule(Schedule schedule);

    Schedule findByUuid (String uuid);
}
