package com.modular_monolith.assessment1.appointment_booking.internal.application.appointment;

import java.util.UUID;

public record BookAppointmentDto(UUID slotId, UUID patientId) {

    @Override
    public String toString() {
        return "CreateAppointmentDto{" +
                "slotId=" + slotId +
                ", patientId=" + patientId +
                '}';
    }
}
