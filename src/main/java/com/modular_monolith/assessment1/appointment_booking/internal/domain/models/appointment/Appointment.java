package com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient.Patient;
import com.modular_monolith.assessment1.shared.exceptions.AppException;

import java.time.LocalDateTime;
import java.util.UUID;

public class Appointment {

    private final AppointmentId id;
    private UUID slotId;
    private Patient patient;
    private LocalDateTime reservedAt;
    private AppointmentStatus status;

    public Appointment() {
        id = null;
        status = null;
    }

    public Appointment(AppointmentId id, UUID slotId, Patient patient, LocalDateTime reservedAt,AppointmentStatus status) {
        this.id = id;
        this.slotId = slotId;
        this.patient = patient;
        this.reservedAt = reservedAt;
        this.status = status;
    }

    public static Appointment newAppointment (UUID slotId,Patient patient) {
        return new Appointment(
                AppointmentId.generate(),
                slotId,
                patient,
                LocalDateTime.now(),
                AppointmentStatus.CREATED
        );
    }

    public AppointmentId getId() {
        return id;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getReservedAt() {
        return reservedAt;
    }

    public void setReservedAt(LocalDateTime reservedAt) {
        this.reservedAt = reservedAt;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", slotId=" + slotId +
                ", patient=" + patient +
                ", reservedAt=" + reservedAt +
                ", status=" + status +
                '}';
    }

    public void booked() {
        this.status = AppointmentStatus.BOOKED;
    }

    public void changeStatus(String status) {
        try {
            this.status = AppointmentStatus.valueOf(status.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new AppException.BadRequestException("Invalid status: " + status);
        }
    }
}
