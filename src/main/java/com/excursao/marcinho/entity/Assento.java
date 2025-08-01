package com.excursao.marcinho.entity;

import com.excursao.marcinho.enums.StatusAssento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "assento")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Assento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero")
    private Integer numero;

    @OneToMany(mappedBy = "assento")
    private List<Reserva> reserva;
}
