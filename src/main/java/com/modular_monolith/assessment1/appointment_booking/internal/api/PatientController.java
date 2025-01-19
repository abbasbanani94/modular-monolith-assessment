package com.modular_monolith.assessment1.appointment_booking.internal.api;

import com.modular_monolith.assessment1.appointment_booking.internal.application.patient.CreatePatientDto;
import com.modular_monolith.assessment1.appointment_booking.internal.application.patient.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientService patientService;


    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("")
    public ResponseEntity createPatient (@RequestBody CreatePatientDto command) {
        return new ResponseEntity(patientService.createPatient(command), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity getAllPatients () {
        return new ResponseEntity(patientService.getAllPatients(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getPatientById (@PathVariable (value = "id") UUID id) {
        return new ResponseEntity(patientService.getPatientById(id),HttpStatus.OK);
    }
}
