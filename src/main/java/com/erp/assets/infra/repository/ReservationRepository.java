package com.erp.assets.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.erp.assets.domain.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
    @Query("SELECT r FROM Reservation r WHERE r.assetId = :assetId AND r.endDate > :start AND r.startDate < :end")
    List<Reservation> findConflicts(UUID assetId, LocalDateTime start, LocalDateTime end);
}