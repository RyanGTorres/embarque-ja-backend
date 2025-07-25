package com.excursao.marcinho.entity;

import jakarta.persistence.*;

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
    private Date dataSaida;

    @Column(name = "data_retorno")
    private Date dataRetorno;

    @OneToOne
    @JoinColumn(name = "excursao_id")
    private Excursao excursao;

    @OneToMany(mappedBy = "roteiro")
    private List<RoteiroEmbarque> roteiroEmbarque;
}
