package com.modular_monolith.assessment1.appointment_booking.internal.api;

import com.modular_monolith.assessment1.appointment_booking.internal.application.appointment.AppointmentService;
import com.modular_monolith.assessment1.appointment_booking.internal.application.appointment.BookAppointmentDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/available-slots")
    public ResponseEntity getAvailableSlots () {
        return new ResponseEntity(appointmentService.getAvailableSlots(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity bookAppointment (@RequestBody BookAppointmentDto command) {
        return new ResponseEntity(appointmentService.bookAppointment(command),HttpStatus.CREATED);
    }
}
