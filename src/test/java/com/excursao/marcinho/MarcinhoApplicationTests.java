package com.excursao.marcinho;

import com.excursao.marcinho.entity.*;
import com.excursao.marcinho.enums.StatusAssento;
import com.excursao.marcinho.repository.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.val;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class MarcinhoApplicationTests {
	@Autowired
	private ReservaRepository reservaRepository;
	@Autowired
	private AssentoRepository assentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OnibusRepository onibusRepository;
	@Autowired
	private ExcursaoRepository excursaoRepository;

	@AfterEach
	void depoisDeCada(){
		reservaRepository.deleteAll();
		clienteRepository.deleteAll();
		onibusRepository.deleteAll();
		assentoRepository.deleteAll();
		excursaoRepository.deleteAll();
	}

	@Test
	void contextLoads() {

		val clientR = clienteRepository.save(Cliente.builder().nome("Fulano").build());
		val onibusviagem = onibusRepository.save(Onibus.builder().empresa("onibusviagem").build());
		val assentoR = assentoRepository.save(Assento.builder().statusAssento(StatusAssento.LIVRE).build());
		val excursao = excursaoRepository.save(Excursao.builder().hotel("Pousada Praia").build());


		val build = Reserva.builder()
						.cliente(clientR)
						.onibus(onibusviagem)
						.assento(assentoR)
						.excursao(excursao)
						.build();
		reservaRepository.save(build);
		reservaRepository.save(build);
	}



}
