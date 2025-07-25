package com.excursao.marcinho.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;
import java.util.List;

@Entity
@Table(name = "roteiro")
public class Roteiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "origem")
    private String origem;

    @Column(name = "destino")
    private String destino;

    @Column(name = "hora_retorno")
    private String horaRetorno;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "data_retorno")
    private LocalDate dataRetorno;

    @OneToOne(mappedBy = "roteiro")
    private Excursao excursao;

    @ManyToMany
    @JoinTable(
            name = "embarque_roteiro",
            joinColumns = @JoinColumn(name = "roteiro_id"),
            inverseJoinColumns = @JoinColumn(name = "embarque_id")
    )
    private List<Embarque> embarques;
}
