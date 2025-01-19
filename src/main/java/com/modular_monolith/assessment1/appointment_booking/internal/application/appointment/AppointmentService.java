package com.modular_monolith.assessment1.appointment_booking.internal.application.appointment;

import com.modular_monolith.assessment1.appointment_booking.internal.application.patient.PatientService;
import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.repositories.AppointmentRepository;
import com.modular_monolith.assessment1.doctor_availability.shared.ISlotAPI;
import com.modular_monolith.assessment1.doctor_availability.shared.SlotDto;
import com.modular_monolith.assessment1.shared.events.EventBus;
import com.modular_monolith.assessment1.shared.exceptions.AppException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    private final ISlotAPI iSlotAPI;
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final EventBus eventBus;

    public AppointmentService(ISlotAPI iSlotAPI, AppointmentRepository appointmentRepository,
                              PatientService patientService, EventBus eventBus) {
        this.iSlotAPI = iSlotAPI;
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
        this.eventBus = eventBus;
    }

    public List<SlotDto> getAvailableSlots() {
        return iSlotAPI.getAvailableSlots();
    }

    private SlotDto checkSlotExistsAndInFuture (UUID slotId) {
        SlotDto slotDto = iSlotAPI.getSlotById(slotId);
        if(slotDto.isReserved() || slotDto.time().isBefore(LocalDateTime.now()))
            throw new AppException.BadRequestException("Slot cannot be reserved, whether its in the past or already reserved");
        return slotDto;
    }

    public AppointmentResponseDto bookAppointment(BookAppointmentDto command) {
        //check slot exist and in the future
        SlotDto slotDto = checkSlotExistsAndInFuture(command.slotId());
        //check patient exist
        Patient patient = patientService.findPatientById(command.patientId());
        Appointment appointment = Appointment.newAppointment(command.slotId(),patient);
        appointment.booked();
        appointment = appointmentRepository.save(appointment);
        //todo add slot reservation event calling
        //1st event to reserve slot
        eventBus.publish(
                new AppointmentBookedEvent(
                        appointment.getId().id(),
                        appointment.getSlotId(),
                        appointment.getPatient().getId().id(),
                        appointment.getPatient().getName().patientName(),
                        slotDto.doctorId(),
                        slotDto.doctorName(),
                        slotDto.time()
                )
        );
        //2nd event to notify doctor and patient

        return AppointmentResponseDto.modelToDto(appointment);
    }
}
