package com.modular_monolith.assessment1.appointment_booking.internal.domain.contracts;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;

import java.util.UUID;

public interface IAppointmentRepo {

    Appointment save (Appointment appointment);

    Appointment getAppointmentBySlotId(UUID uuid);

    Appointment getAppointmentById(UUID appointmentId);
}
