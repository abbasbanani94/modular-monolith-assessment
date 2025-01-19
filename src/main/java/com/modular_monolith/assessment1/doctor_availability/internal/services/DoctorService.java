package com.modular_monolith.assessment1.doctor_availability.internal.services;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import com.modular_monolith.assessment1.doctor_availability.internal.dtos.CreateDoctorDto;
import com.modular_monolith.assessment1.doctor_availability.internal.dtos.DoctorResponseDto;
import com.modular_monolith.assessment1.doctor_availability.internal.entities.DoctorEntity;
import com.modular_monolith.assessment1.doctor_availability.internal.mappers.DoctorMapper;
import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;
import com.modular_monolith.assessment1.doctor_availability.internal.model.slot.Slot;
import com.modular_monolith.assessment1.doctor_availability.internal.repositories.IDoctorRepo;
import com.modular_monolith.assessment1.doctor_availability.internal.repositories.ISlotRepo;
import com.modular_monolith.assessment1.shared.exceptions.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorService {

    private final IDoctorRepo iDoctorRepo;
    private final Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public DoctorService(IDoctorRepo iDoctorRepo) {
        this.iDoctorRepo = iDoctorRepo;
    }

    public DoctorResponseDto createDoctor(CreateDoctorDto command) {
        Doctor doctor = Doctor.newDoctor(command.name());
        return DoctorMapper.modelToDto(iDoctorRepo.save(doctor));
    }

    public List<DoctorResponseDto> getAllDoctors() {
        return iDoctorRepo.getAllDoctors()
                .orElseThrow(() -> new AppException.NotFoundException("No Doctors Created"))
                .stream()
                .map(DoctorMapper::modelToDto)
                .toList();
    }

    public Doctor findDoctorById (UUID id) {
        return iDoctorRepo.getDoctorById(id)
                .orElseThrow(() -> new AppException.NotFoundException("Doctor not Found"));
    }

    public DoctorResponseDto getDoctorById(UUID id) {
        return DoctorMapper.modelToDto(
                findDoctorById(id)
        );
    }

    public void notifyDoctor(AppointmentBookedEvent event) {
        log.info(event.doctorName() + " has been booked in " + event.slotTime() + " with patient " + event.patientName());
    }
}
