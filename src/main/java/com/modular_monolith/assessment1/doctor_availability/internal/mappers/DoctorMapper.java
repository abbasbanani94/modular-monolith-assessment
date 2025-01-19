package com.modular_monolith.assessment1.doctor_availability.internal.mappers;

import com.modular_monolith.assessment1.doctor_availability.internal.dtos.DoctorResponseDto;
import com.modular_monolith.assessment1.doctor_availability.internal.entities.DoctorEntity;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.DoctorId;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.DoctorName;

public class DoctorMapper {

    public static DoctorEntity modelToEntity (Doctor doctor) {
        return new DoctorEntity(
                doctor.getId().id(),
                doctor.getName().doctorName()
        );
    }

    public static DoctorResponseDto entityToDto(DoctorEntity doctorEntity) {
        return new DoctorResponseDto(
                doctorEntity.getId(),
                doctorEntity.getName()
        );
    }

    public static Doctor entityToModel(DoctorEntity doctorEntity) {
        return new Doctor(new DoctorId(doctorEntity.getId()),new DoctorName(doctorEntity.getName()));
    }

    public static DoctorResponseDto modelToDto(Doctor doctor) {
        return new DoctorResponseDto(
                doctor.getId().id(),
                doctor.getName().doctorName()
        );
    }
}
