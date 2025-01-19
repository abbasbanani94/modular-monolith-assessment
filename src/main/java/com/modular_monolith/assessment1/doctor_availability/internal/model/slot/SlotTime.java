package com.modular_monolith.assessment1.doctor_availability.internal.model.slot;

import com.modular_monolith.assessment1.shared.validators.ValueValidator;

import java.time.LocalDateTime;

public record SlotTime(LocalDateTime time) {

    public SlotTime {
        ValueValidator.assertNotInPast(getClass(), time);
    }

    public static SlotTime create(LocalDateTime time) {
        return new SlotTime(time);
    }

    @Override
    public String toString() {
        return time.toString();
    }
}
