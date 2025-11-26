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
@RequestMapping("/{companyId}/sched")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<?> getSchedules(@PathVariable Long companyId) {
        List<Schedule> schedules = scheduleService.findAllSchedulesByCompany(companyId);
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Schedule>> getSchedule(@PathVariable Long companyId, @PathVariable Long id) {
        return ResponseEntity.ok(scheduleService.findScheduleByIdAndCompany(id, companyId));
    }

    @PostMapping
    public ResponseEntity<Schedule> createSchedule(@PathVariable Long companyId, @RequestBody ScheduleDTO schedule) {
        return ResponseEntity.ok(scheduleService.save(schedule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long companyId, @PathVariable Long id,
                                                   @RequestBody ScheduleDTO schedule) {
        return ResponseEntity.ok(scheduleService.update(id, companyId, schedule));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable Long companyId, @PathVariable Long id) {
        scheduleService.delete(id, companyId);
        return ResponseEntity.ok().build();
    }
}
