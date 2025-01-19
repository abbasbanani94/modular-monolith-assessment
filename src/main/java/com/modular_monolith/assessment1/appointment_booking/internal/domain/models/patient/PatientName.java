package com.modular_monolith.assessment1.appointment_booking.internal.domain.models.patient;

import com.modular_monolith.assessment1.shared.validators.ValueValidator;

public record PatientName(String patientName) {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 50;

    public PatientName {
        ValueValidator.assertWithinRange(getClass(), patientName, MIN_LENGTH, MAX_LENGTH);
    }

    public static PatientName create(String patientName) {
        return new PatientName(patientName);
    }

    @Override
    public String toString() {
        return patientName;
    }
}
