package com.paledev.hobbsched.services;

import com.paledev.hobbsched.dto.ScheduleDTO;
import com.paledev.hobbsched.models.Schedule;
import com.paledev.hobbsched.repositories.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    private void setScheduleValues(Schedule schedule, ScheduleDTO dto) {
        schedule.setScheduleDateTime(dto.getDateTime());
        schedule.setClient(dto.getClient());
        schedule.setService(dto.getService());
        schedule.setCompany(dto.getCompany());
    }

    public Schedule save(ScheduleDTO dto){
        Schedule schedule = new Schedule();
        setScheduleValues(schedule, dto);
        return  scheduleRepository.save(schedule);
    }
    public Schedule update(Long id ,ScheduleDTO dto){
        Schedule schedule = findScheduleById(id).orElseThrow(()
        -> new RuntimeException("Schedule Not Found!"));
        return  scheduleRepository.save(schedule);
    }
    public void delete(Long id){
        Schedule schedule = findScheduleById(id).orElseThrow(()
        -> new RuntimeException("Schedule Not Found!"));
        scheduleRepository.delete(schedule);
    }

    public List<Schedule> findAllSchedules(){
        return scheduleRepository.findAll();
    }

    public Optional<Schedule> findScheduleById(Long id){
        return scheduleRepository.findById(id);
    }

}
