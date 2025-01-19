package com.modular_monolith.assessment1.doctor_availability.internal.model.doctor;

public class Doctor {

    private final DoctorId id;
    private final DoctorName name;

    public Doctor() {
        id = null;
        name = null;
    }

    public Doctor(DoctorId id, DoctorName name) {
        this.id = id;
        this.name = name;
    }

    public static Doctor newDoctor (String name) {
        return new Doctor(
                DoctorId.generate(),
                DoctorName.create(name)
        );
    }

    public DoctorId getId() {
        return id;
    }

    public DoctorName getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
