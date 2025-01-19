package com.modular_monolith.assessment1.appointment_booking.shared.events;

import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentBookedEvent(UUID appointmentID, UUID slotId, UUID patientId, String patientName,
                                     UUID doctorId, String doctorName, LocalDateTime slotTime) {

    @Override
    public String toString() {
        return "AppointmentBookedEvent{" +
                "appointmentID=" + appointmentID +
                ", slotId=" + slotId +
                ", patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", doctorId=" + doctorId +
                ", doctorName='" + doctorName + '\'' +
                ", slotTime=" + slotTime +
                '}';
    }
}
