package com.excursao.marcinho.entity;

import com.excursao.marcinho.enums.StatusAssento;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(name = "criada_em")
    private LocalDateTime criadaEm;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_assento")
    private StatusAssento statusAssento;

    @Column(name = "numero_assento")
    private Integer numeroAssento;

    @ManyToOne
    @JoinColumn(name = "excursaoOnibus_id")
    private ExcursaoOnibus excursaoOnibus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}
