package com.modular_monolith.assessment1.appointment_confirmation;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import com.modular_monolith.assessment1.appointment_booking.shared.api.patient.IPatientAPI;
import com.modular_monolith.assessment1.doctor_availability.shared.IDoctorAPI;
import com.modular_monolith.assessment1.shared.events.EventBus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppointmentBookedHandler {

    private final EventBus eventBus;
    private final IDoctorAPI iDoctorAPI;
    private final IPatientAPI iPatientAPI;

    public AppointmentBookedHandler(EventBus eventBus, IDoctorAPI iDoctorAPI, IPatientAPI iPatientAPI) {
        this.eventBus = eventBus;
        this.iDoctorAPI = iDoctorAPI;
        this.iPatientAPI = iPatientAPI;
        this.eventBus.registerListener(this);
    }

    @EventListener
    public void notifyDoctor(AppointmentBookedEvent event) {
        iDoctorAPI.notifyDoctor(event);
    }

    @EventListener
    public void notifyPatient(AppointmentBookedEvent event) {
        iPatientAPI.notifyPatient(event);
    }
}
