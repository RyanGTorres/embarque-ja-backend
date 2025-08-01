package com.excursao.marcinho.entity;

import com.excursao.marcinho.enums.StatusAssento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reserva")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "criado_em")
    private LocalDateTime criadoEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_assento")
    private StatusAssento statusAssento;

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
