package com.modular_monolith.assessment1.appointment_booking.shared.api.patient;

import com.modular_monolith.assessment1.appointment_booking.internal.application.patient.PatientService;
import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import org.springframework.stereotype.Component;

@Component
public class PatientAPI implements IPatientAPI {

    private final PatientService patientService;

    public PatientAPI(PatientService patientService) {
        this.patientService = patientService;
    }


    @Override
    public void notifyPatient(AppointmentBookedEvent event) {
        patientService.notifyPatient(event);
    }
}
