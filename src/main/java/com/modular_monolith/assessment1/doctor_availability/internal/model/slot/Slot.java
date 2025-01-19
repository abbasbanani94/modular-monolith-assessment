package com.modular_monolith.assessment1.doctor_availability.internal.model.slot;

import com.modular_monolith.assessment1.doctor_availability.internal.model.doctor.Doctor;
import com.modular_monolith.assessment1.shared.exceptions.AppException;

import java.time.LocalDateTime;

public class Slot {

    private final SlotId id;
    private SlotTime time;
    private Doctor doctor;
    private Boolean isReserved;
    private Double cost;

    public Slot() {
        id = null;
    }

    public Slot(SlotId id, SlotTime time, Doctor doctor, Boolean isReserved, Double cost) {
        this.id = id;
        this.time = time;
        this.doctor = doctor;
        this.isReserved = isReserved;
        this.cost = cost;
    }

    public static Slot newSlot (LocalDateTime time,Doctor doctor,Double cost) {
        return new Slot (
                SlotId.generate(),
                SlotTime.create(time),
                doctor,
                false,
                cost
        );
    }

    public SlotId getId() {
        return id;
    }

    public SlotTime getTime() {
        return time;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public Double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", time=" + time +
                ", doctor=" + doctor +
                ", isReserved=" + isReserved +
                ", cost=" + cost +
                '}';
    }

    public void reserve() {
        if(this.isReserved)
            throw new AppException.RequirementException("this slot is already reserved");
        this.isReserved = true;
    }
}
