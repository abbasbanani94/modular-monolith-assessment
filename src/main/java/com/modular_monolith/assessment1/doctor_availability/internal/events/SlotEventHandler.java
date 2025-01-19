package com.modular_monolith.assessment1.doctor_availability.internal.events;

import com.modular_monolith.assessment1.appointment_booking.shared.events.AppointmentBookedEvent;
import com.modular_monolith.assessment1.doctor_availability.internal.services.DoctorService;
import com.modular_monolith.assessment1.doctor_availability.internal.services.SlotService;
import com.modular_monolith.assessment1.shared.events.EventBus;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SlotEventHandler {

    private final SlotService slotService;
    private final EventBus eventBus;

    public SlotEventHandler(SlotService slotService, EventBus eventBus) {
        this.slotService = slotService;
        this.eventBus = eventBus;
        this.eventBus.registerListener(this);
    }

    @EventListener
    public void handleSlotReservation(AppointmentBookedEvent event) {
        slotService.reserveSlot(event.slotId());
    }
}
