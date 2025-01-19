package com.modular_monolith.assessment1.doctor_availability.internal.db;

import com.modular_monolith.assessment1.doctor_availability.internal.entities.DoctorEntity;
import com.modular_monolith.assessment1.doctor_availability.internal.mappers.DoctorMapper;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;
import com.modular_monolith.assessment1.doctor_availability.internal.repositories.IDoctorRepo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class DoctorRepository implements IDoctorRepo {
    private final JpaDoctorRepository jpaDoctorRepository;

    public DoctorRepository(JpaDoctorRepository jpaDoctorRepository) {
        this.jpaDoctorRepository = jpaDoctorRepository;
    }

    @Override
    public Doctor save(Doctor doctor) {
        DoctorEntity doctorEntity = DoctorMapper.modelToEntity(doctor);
        return DoctorMapper.entityToModel(jpaDoctorRepository.save(doctorEntity));
    }

    @Override
    public Optional<List<Doctor>> getAllDoctors() {
        return Optional.of(
                jpaDoctorRepository.findAll()
                        .stream()
                        .map(DoctorMapper::entityToModel)
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<Doctor> getDoctorById(UUID id) {
        return jpaDoctorRepository.findById(id)
                .map(DoctorMapper::entityToModel);
    }
}
