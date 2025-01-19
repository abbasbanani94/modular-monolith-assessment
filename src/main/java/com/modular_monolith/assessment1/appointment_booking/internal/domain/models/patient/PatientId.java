package com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient;

import java.util.UUID;

public record PatientId(UUID id) {

    public static PatientId generate () {
        return new PatientId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "PatientId{" +
                "id=" + id +
                '}';
    }
}
