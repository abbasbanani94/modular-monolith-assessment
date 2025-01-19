package com.modular_monolith.assessment1.doctor_availability.internal.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateSlotDto(UUID doctorId,LocalDateTime time,Double cost) {

    @Override
    public String toString() {
        return "CreateSlotDto{" +
                "doctorId=" + doctorId +
                ", time=" + time +
                ", cost=" + cost +
                '}';
    }
}
