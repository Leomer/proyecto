package com.upc.proyecto.infrastructure.adapter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specialty")
public class SpecialtyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialtyId;

    private String specialtyName;
    private boolean status;

}
