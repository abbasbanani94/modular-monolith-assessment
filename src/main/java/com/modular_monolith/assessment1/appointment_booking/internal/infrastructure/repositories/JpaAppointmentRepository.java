package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.repositories;

import com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities.AppointmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface JpaAppointmentRepository extends JpaRepository<AppointmentEntity, UUID> {

    @Query(value = "select * from appointments where slot_id = :slotId",nativeQuery = true)
    Optional<AppointmentEntity> getAppointmentBySlotId(@Param("slotId") UUID slotId);
}
