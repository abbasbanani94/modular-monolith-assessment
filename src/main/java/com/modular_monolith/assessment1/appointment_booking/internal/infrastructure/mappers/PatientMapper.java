package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.mappers;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.PatientId;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.PatientName;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities.PatientEntity;

public class PatientMapper {

    public static PatientEntity modelToEntity(Patient patient) {
        return new PatientEntity(
                patient.getId().id(),
                patient.getName().patientName()
        );
    }

    public static Patient entityToModel(PatientEntity patientEntity) {
        return new Patient(
                new PatientId(patientEntity.getId()),
                new PatientName(patientEntity.getName())
        );
    }
}
