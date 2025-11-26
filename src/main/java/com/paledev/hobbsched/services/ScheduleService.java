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
        schedule.setClient(dto.getClientId());
        schedule.setService(dto.getService());
        schedule.setCompany(dto.getCompanyId());
    }

    public Schedule save(ScheduleDTO dto){
        Schedule schedule = new Schedule();
        setScheduleValues(schedule, dto);
        return  scheduleRepository.save(schedule);
    }
    public Schedule update(Long id, Long company , ScheduleDTO dto){
        Schedule schedule = findScheduleByIdAndCompany(id, company).orElseThrow(()
        -> new RuntimeException("Schedule Not Found!"));
        return  scheduleRepository.save(schedule);
    }
    public void delete(Long id, Long company){
        Schedule schedule = findScheduleByIdAndCompany(id, company).orElseThrow(()
        -> new RuntimeException("Schedule Not Found!"));
        scheduleRepository.delete(schedule);
    }

    public List<Schedule> findAllSchedulesByCompany(Long company){
        return scheduleRepository.findAllByCompany(company);
    }

    public Optional<Schedule> findScheduleByIdAndCompany(Long id, Long company){
        return scheduleRepository.findByScheduleIdAndCompany(id, company);
    }

}
