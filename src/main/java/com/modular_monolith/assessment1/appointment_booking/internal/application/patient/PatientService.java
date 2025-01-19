package com.modular_monolith.assessment1.appointment_booking.internal.application.patient;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.contracts.IPatientRepo;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;
import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import com.modular_monolith.assessment1.doctor_availability.shared.ISlotAPI;
import com.modular_monolith.assessment1.doctor_availability.shared.SlotDto;
import com.modular_monolith.assessment1.shared.exceptions.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    private final IPatientRepo iPatientRepo;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public PatientService(IPatientRepo iPatientRepo) {
        this.iPatientRepo = iPatientRepo;
    }

    public PatientResponseDto createPatient(CreatePatientDto command) {
        Patient patient = iPatientRepo.save(Patient.newPatient(command.name()));
        return PatientResponseDto.modelToDto(patient);
    }

    public List<PatientResponseDto> getAllPatients() {
        return iPatientRepo.getAllPatients()
                .orElseThrow(() -> new AppException.NotFoundException("No Patients Created"))
                .stream()
                .map(PatientResponseDto::modelToDto)
                .toList();
    }

    public Patient findPatientById (UUID id) {
        return iPatientRepo.getPatientById(id)
                .orElseThrow(() -> new AppException.NotFoundException("Patient not Found"));
    }

    public PatientResponseDto getPatientById(UUID id) {
        return PatientResponseDto.modelToDto(findPatientById(id));
    }

    public void notifyPatient(AppointmentBookedEvent event) {
        log.info(event.patientName() + " booked appointment with doctor " + event.doctorName() + " at " + event.slotTime());
    }
}
