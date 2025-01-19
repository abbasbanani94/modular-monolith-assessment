package com.modular_monolith.assessment1.appointment_booking.shared.api.appointment;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.AppointmentStatus;
import com.modular_monolith.assessment1.doctor_availability.shared.SlotDto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentDto(UUID appointmentId, UUID patientId, String patientName,
                             LocalDateTime slotTime, AppointmentStatus status) {

    public static AppointmentDto from(Appointment appointment, SlotDto slot) {
        return new AppointmentDto(
                appointment.getId().id(),
                appointment.getPatient().getId().id(),
                appointment.getPatient().getName().patientName(),
                slot.time(),
                appointment.getStatus()
        );
    }
}
