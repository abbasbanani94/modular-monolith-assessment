package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.repositories;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.contracts.IAppointmentRepo;
import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.Appointment;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities.AppointmentEntity;
import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.mappers.AppointmentMapper;
import com.modular_monolith.assessment1.shared.exceptions.AppException;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AppointmentRepository implements IAppointmentRepo {

    private final JpaAppointmentRepository jpaAppointmentRepository;

    public AppointmentRepository(JpaAppointmentRepository jpaAppointmentRepository) {
        this.jpaAppointmentRepository = jpaAppointmentRepository;
    }

    @Override
    public Appointment save(Appointment appointment) {
        AppointmentEntity appointmentEntity = AppointmentMapper.modelToEntity(appointment);
        return AppointmentMapper.entityToModel(
                jpaAppointmentRepository.save(appointmentEntity)
        );
    }

    @Override
    public Appointment getAppointmentBySlotId(UUID slotId) {
        return AppointmentMapper.entityToModel(
                jpaAppointmentRepository.getAppointmentBySlotId(slotId)
                        .orElseThrow(() -> new AppException.NotFoundException("Appointment not Found")));
    }

    @Override
    public Appointment getAppointmentById(UUID appointmentId) {
        return AppointmentMapper.entityToModel(
                jpaAppointmentRepository.findById(appointmentId)
                        .orElseThrow(() -> new AppException.NotFoundException("Appointment not found"))
        );
    }
}
