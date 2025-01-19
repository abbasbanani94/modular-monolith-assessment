package com.modular_monolith.assessment1.doctor_availability.internal.repositories;

import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDoctorRepo {

    Doctor save (Doctor doctor);
    Optional<List<Doctor>> getAllDoctors ();
    Optional<Doctor> getDoctorById (UUID id);
}
