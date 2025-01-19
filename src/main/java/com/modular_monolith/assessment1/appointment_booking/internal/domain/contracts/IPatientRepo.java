package com.modular_monolith.assessment1.appointment_booking.internal.domain.contracts;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IPatientRepo {

    Patient save (Patient patient);
    Optional<List<Patient>> getAllPatients ();
    Optional<Patient> getPatientById (UUID id);
}
