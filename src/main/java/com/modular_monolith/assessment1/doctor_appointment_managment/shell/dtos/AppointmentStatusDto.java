package com.modular_monolith.assessment1.doctor_appointment_managment.shell.dtos;

import java.util.UUID;

public record AppointmentStatusDto(UUID appointmentId,String status) {
}
