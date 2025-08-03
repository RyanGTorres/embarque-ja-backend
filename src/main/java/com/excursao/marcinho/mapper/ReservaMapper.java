package com.excursao.marcinho.mapper;

import com.excursao.marcinho.dto.response.AssentoView;
import com.excursao.marcinho.dto.response.ReservaResponse;
import com.excursao.marcinho.entity.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mapping(source = "cliente.cpf", target = "cpfCliente")
    @Mapping(source = "cliente.nome", target = "nomeCliente")
    ReservaResponse toResponse(Reserva reserva);

    List<ReservaResponse> toListResponse(List<Reserva> reservas);

    @Mapping(source = "cliente.nome", target = "clienteNome")
    @Mapping(source = "cliente.id", target = "clienteId")
    @Mapping(source = "numeroAssento", target = "numero")
    @Mapping(constant = "OCUPADO", target = "status")
    AssentoView toAssentoView(Reserva reserva);
}
