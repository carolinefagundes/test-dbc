package com.test.dbc.agibank.repositories;

import com.test.dbc.agibank.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, String> {

    Schedule findByUuid (String uuid);

}
