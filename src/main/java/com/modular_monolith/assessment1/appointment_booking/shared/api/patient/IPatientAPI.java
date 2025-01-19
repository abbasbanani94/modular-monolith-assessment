package com.modular_monolith.assessment1.appointment_booking.shared.api.patient;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;

public interface IPatientAPI {

    void notifyPatient (AppointmentBookedEvent event);
}
