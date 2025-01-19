package com.modular_monolith.assessment1.doctor_availability.shared;

import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;

import java.time.LocalDateTime;
import java.util.UUID;

public record SlotDto(UUID slotId, UUID doctorId, String doctorName, LocalDateTime time, Boolean isReserved,
                      Double cost) {

    public static SlotDto from(Slot slot) {
        return new SlotDto(
                slot.getId().id(),
                slot.getDoctor().getId().id(),
                slot.getDoctor().getName().doctorName(),
                slot.getTime().time(),
                slot.getReserved(),
                slot.getCost()
        );
    }
}
