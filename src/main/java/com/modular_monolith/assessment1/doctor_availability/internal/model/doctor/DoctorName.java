package com.modular_monolith.assessment1.doctor_availability.internal.model.doctor;

import com.modular_monolith.assessment1.shared.validators.ValueValidator;

public record DoctorName(String doctorName) {

    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 50;

    public DoctorName {
        ValueValidator.assertWithinRange(getClass(), doctorName, MIN_LENGTH, MAX_LENGTH);
    }

    public static DoctorName create(String value) {
        return new DoctorName(value);
    }

    @Override
    public String toString() {
        return doctorName;
    }
}