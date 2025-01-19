package com.modular_monolith.assessment1.doctor_availability.internal.mappers;

import com.modular_monolith.assessment1.doctor_availability.internal.dtos.SlotResponseDto;
import com.modular_monolith.assessment1.doctor_availability.internal.entities.DoctorEntity;
import com.modular_monolith.assessment1.doctor_availability.internal.entities.SlotEntity;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.SlotId;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.SlotTime;

public class SlotMapper {

    public static SlotEntity modelToEntity(Slot slot) {
        return new SlotEntity(
                slot.getId().id(),
                slot.getTime().time(),
                DoctorMapper.modelToEntity(slot.getDoctor()),
                slot.getReserved(),
                slot.getCost()
        );
    }

    public static SlotResponseDto entityToDto(SlotEntity slotEntity) {
        return new SlotResponseDto(
                slotEntity.getId(),
                slotEntity.getDoctor().getId(),
                slotEntity.getDoctor().getName(),
                slotEntity.getTime(),
                slotEntity.getReserved(),
                slotEntity.getCost()
        );
    }

    public static SlotResponseDto modelToDto(Slot slot) {
        return new SlotResponseDto(
                slot.getId().id(),
                slot.getDoctor().getId().id(),
                slot.getDoctor().getName().doctorName(),
                slot.getTime().time(),
                slot.getReserved(),
                slot.getCost()
        );
    }

    public static Slot entityToModel(SlotEntity slotEntity) {
        return new Slot(
                new SlotId(slotEntity.getId()),
                new SlotTime(slotEntity.getTime()),
                DoctorMapper.entityToModel(slotEntity.getDoctor()),
                slotEntity.getReserved(),
                slotEntity.getCost()
        );
    }
}
