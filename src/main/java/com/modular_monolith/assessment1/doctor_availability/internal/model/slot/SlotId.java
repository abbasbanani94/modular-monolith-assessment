package com.modular_monolith.assessment1.doctor_availability.internal.model.slot;

import java.util.UUID;

public record SlotId(UUID id) {

    public static SlotId generate () {
        return new SlotId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return "SlotId{" +
                "id=" + id +
                '}';
    }
}
