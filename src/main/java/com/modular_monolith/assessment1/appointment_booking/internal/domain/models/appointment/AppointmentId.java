package com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment;

import java.util.UUID;

public record AppointmentId(UUID id) {

    public static AppointmentId generate () {
        return new AppointmentId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "AppointmentId{" +
                "id=" + id +
                '}';
    }
}
