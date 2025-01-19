package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities;

import com.modular_monolith.assessment1.appointment_booking.internal.domain.models.appointment.AppointmentStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "appointments")
public class AppointmentEntity {

    @Id
    @Column(name = "appointment_id")
    private UUID id;

    @Column(name = "slot_id")
    private UUID slotId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @Column(name = "reserved_at")
    private LocalDateTime reservedAt;

    @Column(name = "status")
    private AppointmentStatus status;

    public AppointmentEntity() {
    }

    public AppointmentEntity(UUID id, UUID slotId, PatientEntity patient, LocalDateTime reservedAt,AppointmentStatus status) {
        this.id = id;
        this.slotId = slotId;
        this.patient = patient;
        this.reservedAt = reservedAt;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getSlotId() {
        return slotId;
    }

    public void setSlotId(UUID slotId) {
        this.slotId = slotId;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
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
        return "AppointmentEntity{" +
                "id=" + id +
                ", slotId=" + slotId +
                ", patient=" + patient +
                ", reservedAt=" + reservedAt +
                ", status=" + status +
                '}';
    }
}
