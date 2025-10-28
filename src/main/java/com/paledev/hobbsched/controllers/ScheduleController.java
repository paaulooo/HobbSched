package com.paledev.hobbsched.controllers;

import com.paledev.hobbsched.dto.ScheduleDTO;
import com.paledev.hobbsched.models.Company;
import com.paledev.hobbsched.models.Schedule;
import com.paledev.hobbsched.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/{company}/sched")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<?> getSchedules(@PathVariable Company company) {
        List<Schedule> schedules = scheduleService.findAllSchedulesByCompany(company);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Schedule>> getSchedule(@PathVariable Company company, @PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.findScheduleByIdAndCompany(id, company));
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@PathVariable Company company, @RequestBody ScheduleDTO schedule) {
        return ResponseEntity.ok(scheduleService.save(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Company company, @PathVariable Long id,
                                                   @RequestBody ScheduleDTO schedule) {
        return ResponseEntity.ok(scheduleService.update(id, company, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable Company company, @PathVariable Long id) {
        scheduleService.delete(id, company);
        return ResponseEntity.ok().build();
    }
}
