package com.paledev.hobbsched.dto;

import com.paledev.hobbsched.models.Client;
import com.paledev.hobbsched.models.Company;
import com.paledev.hobbsched.models.Service;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    private LocalDateTime dateTime;
    private Long clientId;
    private Service service;
    private Long companyId;
}
