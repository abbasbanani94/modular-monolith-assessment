package com.modular_monolith.assessment1.doctor_availability.internal.dtos;

import java.util.UUID;

public record DoctorResponseDto(UUID id,String name) {

    @Override
    public String toString() {
        return "DoctorResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
