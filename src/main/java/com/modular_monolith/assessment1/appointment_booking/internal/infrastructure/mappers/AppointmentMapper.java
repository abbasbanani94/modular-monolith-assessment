package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.mappers;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.AppointmentId;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities.AppointmentEntity;

public class AppointmentMapper {
    public static AppointmentEntity modelToEntity(Appointment appointment) {
        return new AppointmentEntity(
                appointment.getId().id(),
                appointment.getSlotId(),
                PatientMapper.modelToEntity(appointment.getPatient()),
                appointment.getReservedAt(),
                appointment.getStatus()
        );
    }

    public static Appointment entityToModel(AppointmentEntity appointmentEntity) {
        return new Appointment(
                new AppointmentId(appointmentEntity.getId()),
                appointmentEntity.getSlotId(),
                PatientMapper.entityToModel(appointmentEntity.getPatient()),
                appointmentEntity.getReservedAt(),
                appointmentEntity.getStatus()
        );
    }
}
