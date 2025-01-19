package com.modular_monolith.assessment1.doctor_availability.internal.db;

import com.modular_monolith.assessment1.doctor_availability.internal.entities.SlotEntity;
import com.modular_monolith.assessment1.doctor_availability.internal.mappers.SlotMapper;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;
import com.modular_monolith.assessment1.doctor_availability.internal.repositories.ISlotRepo;
import com.modular_monolith.assessment1.doctor_availability.shared.SlotDto;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class SlotRepository implements ISlotRepo {

    private final JpaSlotRepository jpaSlotRepository;

    public SlotRepository(JpaSlotRepository jpaSlotRepository) {
        this.jpaSlotRepository = jpaSlotRepository;
    }

    @Override
    public Slot save(Slot slot) {
        SlotEntity slotEntity = SlotMapper.modelToEntity(slot);
        return SlotMapper.entityToModel(jpaSlotRepository.save(slotEntity));
    }

    @Override
    public Optional<List<Slot>> getAllSlots() {
        return Optional.of(
                jpaSlotRepository.findAll()
                        .stream()
                        .map(SlotMapper::entityToModel)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<List<Slot>> getAvailableSlots() {
        return Optional.of(
                jpaSlotRepository.findAll()
                        .stream()
                        .filter(obj -> !obj.getReserved() && obj.getTime().isAfter(LocalDateTime.now()))
                        .map(SlotMapper::entityToModel)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<Slot> getSlotById(UUID id) {
        return jpaSlotRepository.findById(id)
                .map(SlotMapper::entityToModel);
    }

    @Override
    public Optional<List<Slot>> getUpcomingSlotsByDoctorId(UUID doctorId) {
        return Optional.of(
                jpaSlotRepository.findAll()
                        .stream()
                        .filter(obj -> obj.getTime().isAfter(LocalDateTime.now()))
                        .map(SlotMapper::entityToModel)
                        .collect(Collectors.toList())
        );
    }
}
