package com.modular_monolith.assessment1.doctor_appointment_managment.shell.controllers;

import com.modular_monolith.assessment1.doctor_appointment_managment.core.service.AppointmentManagementService;
import com.modular_monolith.assessment1.doctor_appointment_managment.shell.dtos.AppointmentStatusDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/appointment-management")
public class AppointmentManagementController {

    private final AppointmentManagementService appointmentManagementService;

    public AppointmentManagementController(AppointmentManagementService appointmentManagementService) {
        this.appointmentManagementService = appointmentManagementService;
    }

    @GetMapping("/upcoming/{id}")
    public ResponseEntity getUpcomingAppointmentsByDoctorId (@PathVariable(value = "id")UUID doctorId) {
        return new ResponseEntity(appointmentManagementService.getUpcomingAppointmentsByDoctorId(doctorId),
                HttpStatus.OK);
    }

    @PutMapping("/status")
    public ResponseEntity changeAppointmentStatus (@RequestBody AppointmentStatusDto command) {
        return new ResponseEntity(appointmentManagementService.changeAppointmentStatus(command),HttpStatus.OK);
    }
}
