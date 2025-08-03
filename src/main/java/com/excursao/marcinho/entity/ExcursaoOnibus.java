package com.excursao.marcinho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "excursao_onibus")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExcursaoOnibus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "onibus_id")
    private Onibus onibus;

    @ManyToOne
    @JoinColumn(name = "excursao_id")
    private Excursao excursao;
}
