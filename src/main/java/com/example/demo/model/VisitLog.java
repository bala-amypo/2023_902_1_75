package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VisitLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Visitor visitor;

    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private String purpose;
    private String location;

    // 🔥 MUST BE PUBLIC (tests call it directly)
    @PrePersist
    public void prePersist() {
        if (entryTime == null) {
            entryTime = LocalDateTime.now();
        }
    }
}
