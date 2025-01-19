package com.modular_monolith.assessment1.doctor_availability.internal.db;

import com.modular_monolith.assessment1.doctor_availability.internal.entities.SlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaSlotRepository extends JpaRepository<SlotEntity, UUID> {
}
