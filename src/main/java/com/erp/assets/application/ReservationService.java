package com.erp.assets.application;

import com.erp.assets.domain.model.Reservation; 
import com.erp.assets.infra.repository.ReservationRepository; 
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;

    public Reservation create(UUID assetId, String user, LocalDateTime start, LocalDateTime end) {
        if (!repository.findConflicts(assetId, start, end).isEmpty()) {
            throw new RuntimeException("Conflito de horário!");
        }
        Reservation res = Reservation.builder()
            .assetId(assetId)
            .username(user)
            .startDate(start)
            .endDate(end)
            .status("PENDING")
            .build();
        return repository.save(res);
    }

    public void approve(UUID id) {
        Reservation res = repository.findById(id).orElseThrow();
        res.setStatus("APPROVED");
        repository.save(res);
    }
}