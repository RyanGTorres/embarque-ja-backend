package com.excursao.marcinho.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "onibus_id")
    private Onibus onibus;

    @ManyToOne
    @JoinColumn(name = "excursao_id")
    private Excursao excursao;

    @ManyToOne
    @JoinColumn(name = "assento_id")
    private Assento assento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
