package com.modular_monolith.assessment1.appointment_booking.internal.application.patient;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;

import java.util.UUID;

public record PatientResponseDto(UUID id,String name) {

    public static PatientResponseDto modelToDto(Patient patient) {
        return new PatientResponseDto(
                patient.getId().id(),
                patient.getName().patientName()
        );
    }

    @Override
    public String toString() {
        return "PatientResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
