package com.modular_monolith.assessment1.doctor_availability.shared;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;

import java.util.List;
import java.util.UUID;

public interface ISlotAPI {

    List<SlotDto> getAvailableSlots();
    SlotDto getSlotById(UUID slotId);
    List<SlotDto> getUpcomingSlotsByDoctorId(UUID doctorId);
}
