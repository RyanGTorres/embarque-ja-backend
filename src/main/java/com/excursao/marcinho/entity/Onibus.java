package com.excursao.marcinho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Table(name = "onibus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Onibus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "empresa")
    private String empresa;

    @OneToMany(mappedBy = "onibus")
    private List<Reserva> reserva;

}
