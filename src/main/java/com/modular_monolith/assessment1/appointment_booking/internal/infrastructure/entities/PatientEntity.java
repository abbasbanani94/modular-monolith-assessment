package com.modular_monolith.assessment1.appointment_booking.internal.infrastructure.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "patients")
public class PatientEntity {

    @Id
    @Column(name = "patient_id")
    private UUID id;

    @Column(name = "patient_name")
    private String name;

    public PatientEntity() {
    }

    public PatientEntity(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PatientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
