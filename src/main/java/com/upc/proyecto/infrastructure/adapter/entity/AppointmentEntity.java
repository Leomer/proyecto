package com.upc.proyecto.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "appointment")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentId;

    private Long userId;
    private String holder;
    private String doctorId;
    private Instant createdAt;
    private String appointmentDate;
    private String appointmentTime;
    private Integer status;
}
