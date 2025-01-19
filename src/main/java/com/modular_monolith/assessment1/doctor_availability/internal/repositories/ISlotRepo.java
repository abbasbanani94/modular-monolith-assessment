package com.modular_monolith.assessment1.doctor_availability.internal.repositories;

import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;
import com.modular_monolith.assessment1.doctor_availability.shared.SlotDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ISlotRepo {

    Slot save (Slot slot);
    Optional<List<Slot>> getAllSlots ();
    Optional<List<Slot>> getAvailableSlots ();
    Optional<Slot> getSlotById (UUID id);

    Optional<List<Slot>> getUpcomingSlotsByDoctorId(UUID doctorId);
}
