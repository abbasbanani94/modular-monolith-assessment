package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.repositories;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.contracts.IPatientRepo;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities.PatientEntity;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.mappers.PatientMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class PatientRepository implements IPatientRepo {

    private final JpaPatientRepository jpaPatientRepository;

    public PatientRepository(JpaPatientRepository jpaPatientRepository) {
        this.jpaPatientRepository = jpaPatientRepository;
    }

    @Override
    public Patient save(Patient patient) {
        PatientEntity patientEntity = PatientMapper.modelToEntity(patient);
        return PatientMapper.entityToModel(jpaPatientRepository.save(patientEntity));
    }

    @Override
    public Optional<List<Patient>> getAllPatients() {
        return Optional.of(jpaPatientRepository.findAll()
                .stream()
                .map(PatientMapper::entityToModel)
                .collect(Collectors.toList()));
    }

    @Override
    public Optional<Patient> getPatientById(UUID id) {
        return jpaPatientRepository.findById(id)
                .map(PatientMapper::entityToModel);
    }
}
