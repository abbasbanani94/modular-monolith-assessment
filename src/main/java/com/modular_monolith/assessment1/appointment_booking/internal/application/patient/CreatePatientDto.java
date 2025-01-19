package com.modular_monolith.assessment1.appointment_booking.internal.application.patient;

public record CreatePatientDto(String name) {

    @Override
    public String toString() {
        return "CreatePatientDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
