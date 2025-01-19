package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.repositories;

import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaPatientRepository extends JpaRepository<PatientEntity, UUID> {
}
