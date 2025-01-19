package com.modular_monolith.assessment1.appointment_booking.internal.application.appointment;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentResponseDto(UUID id, UUID slotId, UUID patientId, String patientName,
                                     LocalDateTime reservedAt, AppointmentStatus status) {

    public static AppointmentResponseDto modelToDto (Appointment appointment) {
        return new AppointmentResponseDto(
                appointment.getId().id(),
                appointment.getSlotId(),
                appointment.getPatient().getId().id(),
                appointment.getPatient().getName().patientName(),
                appointment.getReservedAt(),
                appointment.getStatus()
        );
    }
}
