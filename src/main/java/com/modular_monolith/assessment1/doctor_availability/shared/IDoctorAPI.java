package com.modular_monolith.assessment1.doctor_availability.shared;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;

public interface IDoctorAPI {

    void notifyDoctor (AppointmentBookedEvent event);
}
