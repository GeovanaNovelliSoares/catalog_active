package com.erp.assets.api;

import com.erp.assets.application.ReservationService;
import com.erp.assets.domain.model.Reservation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.UUID;

record ReservationReq(UUID assetId, LocalDateTime start, LocalDateTime end) {}

@RestController
@RequestMapping("/api/v1/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody ReservationReq req, Authentication auth) {
        return ResponseEntity.ok(service.create(req.assetId(), auth.getName(), req.start(), req.end()));
    }
}