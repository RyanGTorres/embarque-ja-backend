package com.excursao.marcinho.entity;

import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "onibus")
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
