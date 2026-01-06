package com.erp.assets.domain.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private UUID assetId;
    private String username;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
}