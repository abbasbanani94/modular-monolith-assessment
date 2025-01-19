package com.modular_monolith.assessment1.doctor_availability.internal.model.doctor;

import java.util.UUID;

public record DoctorId(UUID id) {

    public static DoctorId generate () {
        return new DoctorId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "DoctorId{" +
                "id=" + id +
                '}';
    }
}
