package com.modular_monolith.assessment1.doctor_availability.internal.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "slots")
public class SlotEntity {

    @Id
    @Column(name = "slot_id")
    private UUID id;

    @Column(name = "time")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctorEntity;

    @Column(name = "is_reserved")
    private Boolean isReserved;

    @Column(name = "cost")
    private Double cost;

    public SlotEntity() {
    }

    public SlotEntity(UUID id, LocalDateTime time, DoctorEntity doctorEntity, Boolean isReserved, Double cost) {
        this.id = id;
        this.time = time;
        this.doctorEntity = doctorEntity;
        this.isReserved = isReserved;
        this.cost = cost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public DoctorEntity getDoctor() {
        return doctorEntity;
    }

    public void setDoctor(DoctorEntity doctorEntity) {
        this.doctorEntity = doctorEntity;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", time=" + time +
                ", doctor=" + doctorEntity +
                ", isReserved=" + isReserved +
                ", cost=" + cost +
                '}';
    }
}
