package com.modular_monolith.assessment1.appointment_booking.shared.api.appointment;

import java.util.List;
import java.util.UUID;

public interface IAppointmentAPI {

    List<AppointmentDto> getUpcomingAppointmentsByDoctorId (UUID doctorId);
    AppointmentDto changeAppointmentStatus (UUID appointmentId,String status);

}
