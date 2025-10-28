package com.paledev.hobbsched.repositories;

import com.paledev.hobbsched.models.Company;
import com.paledev.hobbsched.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    Optional<Schedule> findByScheduleIdAndCompany(Long scheduleId, Company company);

    List<Schedule> findAllByCompany(Company company);
}
