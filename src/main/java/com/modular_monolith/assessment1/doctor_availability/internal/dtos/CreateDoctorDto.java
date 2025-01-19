package com.modular_monolith.assessment1.doctor_availability.internal.dtos;

public record CreateDoctorDto(String name) {

    @Override
    public String toString() {
        return "CreateDoctorDto{" +
                "doctorName='" + name + '\'' +
                '}';
    }
}
