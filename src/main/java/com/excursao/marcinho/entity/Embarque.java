package com.excursao.marcinho.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "embarque")
public class Embarque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "local_embarque")
    private String localEmbarque;

    @Column(name = "hora_embarque")
    private String horaEmbarque;

    @OneToMany(mappedBy = "embarque")
    private List<RoteiroEmbarque> roteiroEmbarque;
}
