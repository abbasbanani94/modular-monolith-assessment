package com.modular_monolith.assessment1.doctor_availability.internal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "doctors")
public class DoctorEntity {

    @Id
    @Column(name = "doctor_id")
    private UUID id;

    @Column(name = "doctor_name")
    private String name;

    public DoctorEntity() {
    }

    public DoctorEntity(UUID id, String name) {
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
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
