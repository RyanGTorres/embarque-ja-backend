package com.excursao.marcinho.entity;

import com.excursao.marcinho.enums.StatusViagem;
import jakarta.persistence.*;
import java.util.List;
@Entity
@Table(name = "excursao")
public class Excursao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel")
    private String hotel;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_viagem")
    private StatusViagem statusViagem;

    @OneToOne(mappedBy = "excursao")
    private Roteiro roteiro;

    @OneToMany(mappedBy = "excursao")
    private List<Reserva> reserva;
}
