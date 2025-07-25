package com.excursao.marcinho.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roteiro_embarque")
public class RoteiroEmbarque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roteiro_id")
    private Roteiro roteiro;

    @ManyToOne
    @JoinColumn(name = "embarque_id")
    private Embarque embarque;
}
