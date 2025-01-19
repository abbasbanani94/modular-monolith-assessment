package com.modular_monolith.assessment1.doctor_availability.internal.controllers;

import com.modular_monolith.assessment1.doctor_availability.internal.dtos.CreateDoctorDto;
import com.modular_monolith.assessment1.doctor_availability.internal.services.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("")
    public ResponseEntity createDoctor (@RequestBody CreateDoctorDto command) {
        return new ResponseEntity<>(doctorService.createDoctor(command), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity getAllDoctors () {
        return new ResponseEntity(doctorService.getAllDoctors(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getDoctorById (@PathVariable (value = "id") UUID id) {
        return new ResponseEntity(doctorService.getDoctorById(id),HttpStatus.OK);
    }
}
