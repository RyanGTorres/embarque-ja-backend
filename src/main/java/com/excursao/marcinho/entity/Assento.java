package com.excursao.marcinho.entity;

import com.excursao.marcinho.enums.StatusAssento;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "assento")
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "modelo")
    private String modelo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_assento")
    private StatusAssento statusAssento;

    @OneToMany(mappedBy = "assento")
    private List<Reserva> reserva;
}
