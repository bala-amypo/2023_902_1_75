package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ScoreAuditLog {

    @Id @GeneratedValue
    private Long id;

    private String reason;
    private Integer scoreChange;
}
