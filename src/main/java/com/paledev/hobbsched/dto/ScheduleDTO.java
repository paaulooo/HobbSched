package com.paledev.hobbsched.dto;

import com.paledev.hobbsched.models.Client;
import com.paledev.hobbsched.models.Company;
import com.paledev.hobbsched.models.Service;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    private LocalDateTime dateTime;
    private Client client;
    private Service service;
    private Company company;
}
