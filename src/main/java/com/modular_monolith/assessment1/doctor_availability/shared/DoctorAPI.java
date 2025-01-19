package com.modular_monolith.assessment1.doctor_availability.shared;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import com.modular_monolith.assessment1.doctor_availability.internal.services.DoctorService;
import org.springframework.stereotype.Component;

@Component
public class DoctorAPI implements IDoctorAPI{

    private final DoctorService doctorService;

    public DoctorAPI(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @Override
    public void notifyDoctor(AppointmentBookedEvent event) {
        doctorService.notifyDoctor(event);
    }
}
