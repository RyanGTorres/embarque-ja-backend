package com.excursao.marcinho.entity;

import com.excursao.marcinho.enums.StatusViagem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name = "excursao")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Excursao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel")
    private String hotel;

    @Column(name = "origem")
    private String origem;

    @Column(name = "destino")
    private String destino;

    @Column(name = "data_saida")
    private LocalDate dataSaida;

    @Column(name = "data_retorno")
    private LocalDate dataRetorno;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_viagem")
    private StatusViagem statusViagem;

    @ManyToMany
    @JoinTable(
            name = "embarque_excursao",
            joinColumns = @JoinColumn(name = "excursao_id"),
            inverseJoinColumns = @JoinColumn(name = "embarque_id")
    )
    private List<Embarque> embarques;

    @OneToMany(mappedBy = "excursao")
    private List<ExcursaoOnibus> excursaoOnibus;
}
