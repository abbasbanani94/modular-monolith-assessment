package com.modular_monolith.assessment1.doctor_appointment_managment.core.service;

import com.modular_monolith.assessment1.appointment_booking.shared.api.appointment.AppointmentDto;
import com.modular_monolith.assessment1.appointment_booking.shared.api.appointment.IAppointmentAPI;
import com.modular_monolith.assessment1.doctor_appointment_managment.shell.dtos.AppointmentStatusDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentManagementService {

    private final IAppointmentAPI iAppointmentAPI;

    public AppointmentManagementService(IAppointmentAPI iAppointmentAPI) {
        this.iAppointmentAPI = iAppointmentAPI;
    }

    public List<AppointmentDto> getUpcomingAppointmentsByDoctorId(UUID doctorId) {
        return iAppointmentAPI.getUpcomingAppointmentsByDoctorId(doctorId);
    }

    public AppointmentDto changeAppointmentStatus(AppointmentStatusDto command) {
        return iAppointmentAPI.changeAppointmentStatus(command.appointmentId(),command.status());
    }
}
