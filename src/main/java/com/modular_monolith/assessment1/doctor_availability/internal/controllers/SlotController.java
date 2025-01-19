package com.modular_monolith.assessment1.doctor_availability.internal.controllers;

import com.modular_monolith.assessment1.doctor_availability.internal.dtos.CreateSlotDto;
import com.modular_monolith.assessment1.doctor_availability.internal.services.SlotService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/slot")
public class SlotController {

    private final SlotService slotService;

    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @GetMapping("/available")
    public ResponseEntity getAvailableSlots () {
        return new ResponseEntity(slotService.getAvailableSlots(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity getAllSlots () {
        return new ResponseEntity(slotService.getAllSlots(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity createSlot (@RequestBody CreateSlotDto command) {
        return new ResponseEntity(slotService.createSlot(command),HttpStatus.CREATED);
    }
}
