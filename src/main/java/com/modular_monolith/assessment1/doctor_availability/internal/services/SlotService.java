package com.modular_monolith.assessment1.doctor_availability.internal.services;

import com.modular_monolith.assessment1.doctor_availability.internal.dtos.CreateSlotDto;
import com.modular_monolith.assessment1.doctor_availability.internal.dtos.SlotResponseDto;
import com.modular_monolith.assessment1.doctor_availability.internal.mappers.SlotMapper;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;
import com.modular_monolith.assessment1.doctor_availability.internal.repositories.ISlotRepo;
import com.modular_monolith.assessment1.shared.exceptions.AppException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SlotService {

    private final ISlotRepo iSlotRepo;
    private final DoctorService doctorService;

    public SlotService(ISlotRepo iSlotRepo, DoctorService doctorService) {
        this.iSlotRepo = iSlotRepo;
        this.doctorService = doctorService;
    }

    public List<SlotResponseDto> getAvailableSlots() {
        return iSlotRepo.getAvailableSlots()
                .orElseThrow(() -> new AppException.NotFoundException("No Slots Created"))
                .stream()
                .map(SlotMapper::modelToDto)
                .toList();
    }

    public SlotResponseDto createSlot(CreateSlotDto command) {
        Doctor doctor = doctorService.findDoctorById(command.doctorId());
        Slot slot = Slot.newSlot(
                command.time(),
                doctor,
                command.cost()
        );
        return SlotMapper.modelToDto(iSlotRepo.save(slot));
    }

    public List<SlotResponseDto> getAllSlots() {
        return iSlotRepo.getAllSlots()
                .orElseThrow(() -> new AppException.NotFoundException("No Slots Created"))
                .stream()
                .map(SlotMapper::modelToDto)
                .toList();
    }

    public Slot findSlotById (UUID id) {
        return iSlotRepo.getSlotById(id)
                .orElseThrow(() -> new AppException.NotFoundException("Slot not Found"));
    }

    public void reserveSlot(UUID slotId) {
        Slot slot = findSlotById(slotId);
        slot.reserve();
        iSlotRepo.save(slot);
    }
}
