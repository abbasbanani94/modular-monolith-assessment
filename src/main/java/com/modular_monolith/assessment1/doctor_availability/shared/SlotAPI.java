package com.modular_monolith.assessment1.doctor_availability.shared;

import com.modular_monolith.assessment1.doctor_availability.internal.db.SlotRepository;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;
import com.modular_monolith.assessment1.shared.exceptions.AppException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SlotAPI implements ISlotAPI{

    private final SlotRepository slotRepository;

    public SlotAPI(SlotRepository slotRepository) {
        this.slotRepository = slotRepository;
    }

    @Override
    public List<SlotDto> getAvailableSlots() {
        return slotRepository.getAvailableSlots()
                .orElseThrow(() -> new AppException.NotFoundException("No Available Slots"))
                .stream()
                .map(SlotDto::from)
                .toList();
    }

    private Slot findSlotById (UUID slotId) {
        return slotRepository.getSlotById(slotId)
                .orElseThrow(() -> new AppException.NotFoundException("Slot not Found"));
    }

    @Override
    public SlotDto getSlotById(UUID slotId) {
        return SlotDto.from(findSlotById(slotId));
    }

    @Override
    public List<SlotDto> getUpcomingSlotsByDoctorId(UUID doctorId) {
        return slotRepository.getUpcomingSlotsByDoctorId(doctorId)
                .orElseThrow(() -> new AppException.NotFoundException("No upcoming slots"))
                .stream()
                .map(SlotDto::from)
                .toList();
    }
}
