package com.modular_monolith.assessment1.appointment_booking.shared.api.appointment;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.contracts.IAppointmentRepo;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;
import com.modular_monolith.assessment1.doctor_availability.shared.ISlotAPI;
import com.modular_monolith.assessment1.doctor_availability.shared.SlotDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AppointmentAPI implements IAppointmentAPI{

    private final ISlotAPI iSlotAPI;
    private final IAppointmentRepo iAppointmentRepo;

    public AppointmentAPI(ISlotAPI iSlotAPI, IAppointmentRepo iAppointmentRepo) {
        this.iSlotAPI = iSlotAPI;
        this.iAppointmentRepo = iAppointmentRepo;
    }

    @Override
    public List<AppointmentDto> getUpcomingAppointmentsByDoctorId(UUID doctorId) {
        List<SlotDto> slotDtos =  iSlotAPI.getUpcomingSlotsByDoctorId(doctorId);
        return slotDtos.stream()
                .map(slot -> {
                    Appointment appointment = iAppointmentRepo.getAppointmentBySlotId(slot.slotId());
                    return AppointmentDto.from(appointment,slot);
                }).toList();
    }

    @Override
    public AppointmentDto changeAppointmentStatus(UUID appointmentId, String status) {
        Appointment appointment = iAppointmentRepo.getAppointmentById(appointmentId);
        SlotDto slotDto = iSlotAPI.getSlotById(appointment.getSlotId());
        appointment.changeStatus(status);
        appointment = iAppointmentRepo.save(appointment);
        return AppointmentDto.from(appointment,slotDto);
    }
}
