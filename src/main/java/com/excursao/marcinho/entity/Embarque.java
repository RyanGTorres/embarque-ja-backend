package com.excursao.marcinho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "embarque")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Embarque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "local_embarque")
    private String localEmbarque;

    @Column(name = "horario_embarque")
    private String horarioEmbarque;

    @ManyToMany(mappedBy = "embarques")
    private List<Excursao> excursaos;
}
