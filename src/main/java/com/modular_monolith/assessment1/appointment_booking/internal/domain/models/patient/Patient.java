package com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient;

public class Patient {

    private final PatientId id;
    private PatientName name;

    public Patient() {
        id = null;
    }

    public Patient(PatientId id, PatientName name) {
        this.id = id;
        this.name = name;
    }

    public static Patient newPatient (String name) {
        return new Patient(
                PatientId.generate(),
                PatientName.create(name)
        );
    }

    public PatientId getId() {
        return id;
    }

    public PatientName getName() {
        return name;
    }

    public void setName(PatientName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
