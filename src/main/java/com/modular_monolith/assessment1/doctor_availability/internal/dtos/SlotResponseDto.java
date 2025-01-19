package com.modular_monolith.assessment1.doctor_availability.internal.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

public record SlotResponseDto(UUID id,UUID doctorId,String doctorName,LocalDateTime time,Boolean isReserved,
                              Double cost) {

    @Override
    public String toString() {
        return "SlotResponseDto{" +
                "id=" + id +
                ", doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", time=" + time +
                ", isReserved=" + isReserved +
                ", cost=" + cost +
                '}';
    }
}
